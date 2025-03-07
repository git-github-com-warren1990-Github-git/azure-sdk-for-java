// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.microsoft.azure.spring.cloud.feature.manager;

import static org.junit.Assert.*;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoInteractions;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.method.HandlerMethod;

import reactor.core.publisher.Mono;
/**
 * Unit test for simple App.
 */
@RunWith(MockitoJUnitRunner.class)
public class FeatureHandlerTest {

    @InjectMocks
    FeatureHandler featureHandler;

    @Mock
    FeatureManager featureManager;

    @Mock
    FeatureManagerSnapshot featureManagerSnapshot;

    @Mock
    IDisabledFeaturesHandler disabledFeaturesHandler;

    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Mock
    HandlerMethod handlerMethod;

    @Mock
    FeatureHandler featureHandler2;

    @Test
    public void preHandleNotHandler() {
        assertTrue(featureHandler.preHandle(request, response, new Object()));
    }

    @Test
    public void preHandleNoFeatureOn() throws NoSuchMethodException, SecurityException {
        Method method = TestClass.class.getMethod("noAnnotation");
        when(handlerMethod.getMethod()).thenReturn(method);

        assertTrue(featureHandler.preHandle(request, response, handlerMethod));
    }

    @Test
    public void preHandleFeatureOn() throws NoSuchMethodException, SecurityException {
        Method method = TestClass.class.getMethod("featureOnAnnotation");
        when(handlerMethod.getMethod()).thenReturn(method);
        when(featureManager.isEnabledAsync(Mockito.matches("test"))).thenReturn(Mono.just(true));

        assertTrue(featureHandler.preHandle(request, response, handlerMethod));
    }

    @Test
    public void preHandleFeatureOnSnapshot() throws NoSuchMethodException, SecurityException {
        Method method = TestClass.class.getMethod("featureOnAnnotationSnapshot");
        when(handlerMethod.getMethod()).thenReturn(method);
        when(featureManagerSnapshot.isEnabledAsync(Mockito.matches("test"))).thenReturn(Mono.just(true));

        assertTrue(featureHandler.preHandle(request, response, handlerMethod));
    }

    @Test
    public void preHandleFeatureOnNotEnabled() throws NoSuchMethodException, SecurityException {
        Method method = TestClass.class.getMethod("featureOnAnnotation");
        when(handlerMethod.getMethod()).thenReturn(method);
        when(featureManager.isEnabledAsync(Mockito.matches("test"))).thenReturn(Mono.just(false));

        assertFalse(featureHandler.preHandle(request, response, handlerMethod));
    }

    @Test
    public void preHandleFeatureOnRedirect() throws NoSuchMethodException, SecurityException, IOException {
        Method method = TestClass.class.getMethod("featureOnAnnotationRedirected");
        when(handlerMethod.getMethod()).thenReturn(method);
        when(featureManager.isEnabledAsync(Mockito.matches("test"))).thenReturn(Mono.just(false));

        assertFalse(featureHandler.preHandle(request, response, handlerMethod));

        verify(response).sendRedirect("/redirected");
        verifyNoMoreInteractions(response);
        verifyNoInteractions(disabledFeaturesHandler);
    }

    @Test
    public void preHandleFeatureOnRedirectError() throws NoSuchMethodException, IOException {
        Method method = TestClass.class.getMethod("featureOnAnnotationRedirected");
        when(handlerMethod.getMethod()).thenReturn(method);
        when(featureManager.isEnabledAsync(Mockito.matches("test"))).thenReturn(Mono.just(false));
        IOException ioException = new IOException();
        doThrow(ioException).when(response).sendRedirect("/redirected");

        UndeclaredThrowableException ex = assertThrows(UndeclaredThrowableException.class,
                () -> featureHandler.preHandle(request, response, handlerMethod));

        assertSame(ioException, ex.getCause());
    }

    @Test
    public void preHandleNoDisabledFeatures() throws NoSuchMethodException, SecurityException, IOException {
        featureHandler2 = new FeatureHandler(featureManager, featureManagerSnapshot, null);
        Method method = TestClass.class.getMethod("featureOnAnnotation");
        when(handlerMethod.getMethod()).thenReturn(method);
        when(featureManager.isEnabledAsync(Mockito.matches("test"))).thenReturn(Mono.just(false));

        assertFalse(featureHandler2.preHandle(request, response, handlerMethod));
        verify(response, times(1)).sendError(Mockito.eq(HttpServletResponse.SC_NOT_FOUND));
    }

    @Test
    public void preHandleNoDisabledFeaturesError() throws NoSuchMethodException, SecurityException, IOException {
        featureHandler2 = new FeatureHandler(featureManager, featureManagerSnapshot, null);
        Method method = TestClass.class.getMethod("featureOnAnnotation");
        when(handlerMethod.getMethod()).thenReturn(method);
        when(featureManager.isEnabledAsync(Mockito.matches("test"))).thenReturn(Mono.just(false));

        doThrow(new IOException()).when(response).sendError(Mockito.eq(HttpServletResponse.SC_NOT_FOUND));

        assertFalse(featureHandler2.preHandle(request, response, handlerMethod));
        verify(response, times(1)).sendError(Mockito.eq(HttpServletResponse.SC_NOT_FOUND));
    }

    protected static class TestClass {

        public void noAnnotation() {
        }

        @FeatureGate(feature = "test")
        public void featureOnAnnotation() {
        }

        @FeatureGate(feature = "test", snapshot = true)
        public void featureOnAnnotationSnapshot() {
        }

        @FeatureGate(feature = "test", fallback = "/redirected")
        public void featureOnAnnotationRedirected() {
        }

    }

}
