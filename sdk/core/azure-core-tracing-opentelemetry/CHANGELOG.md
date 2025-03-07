# Release History

## 1.0.0-beta.21 (Unreleased)

### Features Added

### Breaking Changes

### Bugs Fixed

### Other Changes

## 1.0.0-beta.20 (2022-02-04)

### Other Changes

#### Dependency Updates

- Upgraded `azure-core` from `1.24.1` to `1.25.0`.

## 1.0.0-beta.19 (2022-01-11)

### Other Changes

#### Dependency Updates

- Upgraded `azure-core` from `1.24.0` to `1.24.1`.

## 1.0.0-beta.18 (2022-01-06)

### Other Changes

#### Dependency Updates

- Upgraded `azure-core` from `1.23.1` to `1.24.0`.

## 1.0.0-beta.17 (2021-12-07)

### Other Changes

#### Dependency Updates

- Upgraded `azure-core` from `1.22.0` to `1.23.1`.

## 1.0.0-beta.16 (2021-11-05)

### Features Added

- Provide HTTP URL and method before span is started to allow for sampling decisions to be based on them. ([#24996](https://github.com/Azure/azure-sdk-for-java/pull/24996))

### Bugs Fixed

- Fixed OpenTelemetry context propagation and span duplication. ([#25012](https://github.com/Azure/azure-sdk-for-java/pull/25012))
- Fixed inconsistencies in span creation and the OpenTelemetry specification. ([#24954](https://github.com/Azure/azure-sdk-for-java/pull/24954))

### Other Changes

#### Dependency Updates

- Upgraded `azure-core` from `1.21.0` to `1.22.0`.

## 1.0.0-beta.15 (2021-10-01)

### Other Changes

#### Dependency Updates

- Upgraded `azure-core` from `1.20.0` to `1.21.0`.

## 1.0.0-beta.14 (2021-09-07)

### Fixed

- Fixed a case where AMQP span context should set remote parent. ([#21667](https://github.com/Azure/azure-sdk-for-java/pull/21667))

### Other Changes

#### Dependency Updates

- Upgraded `azure-core` from `1.19.0` to `1.20.0`.

## 1.0.0-beta.13 (2021-08-06)

### Features Added

- Added support to create tracing spans with customizations. ([#23159](https://github.com/Azure/azure-sdk-for-java/pull/23159))

### Dependency Updates

- Upgraded `azure-core` from `1.18.0` to `1.19.0`.

## 1.0.0-beta.12 (2021-07-01)

### Key Bugs Fixed

- Fixed `addEvent` API to use the span provided in the context rather than `Span.current()`.

### Dependency Updates

- Upgraded `azure-core` from `1.17.0` to `1.18.0`.

## 1.0.0-beta.11 (2021-06-07)

### Dependency Updates

- Upgraded `azure-core` from `1.16.0` to `1.17.0`.

## 1.0.0-beta.10 (2021-05-07)

### Dependency Updates

- Upgraded `azure-core` from `1.15.0` to `1.16.0`.

## 1.0.0-beta.9 (2021-04-02)

### Dependency Updates

- Upgraded `azure-core` from `1.14.0` to `1.15.0`.

## 1.0.0-beta.8 (2021-03-08)

### Dependency Updates

- Updated `azure-core` from `1.13.0` to `1.14.0`.
- Updated versions of `opentelemetry-api` to `1.0.0` version.
  More detailed information about the new OpenTelemetry API version can be found in [OpenTelemetry changelog](https://github.com/open-telemetry/opentelemetry-java/blob/main/CHANGELOG.md#version-100---2021-02-26).

## 1.0.0-beta.7 (2021-02-05)

### Dependency Updates
- Updated versions of `opentelemetry-api` to `0.14.1` version.
  More detailed information about the new OpenTelemetry API version can be found in [OpenTelemetry changelog](https://github.com/open-telemetry/opentelemetry-java/blob/main/CHANGELOG.md#version-0141---2021-01-14)

## 1.0.0-beta.6 (2020-08-07)
- Update `opentelemetry-api` dependency version to `0.6.0` and included `io.grpc:grpc-context[1.30.0]` external
 dependency .

## 1.0.0-beta.5 (2020-06-08)

- Changed `Tracer` loading logic to only use first in classpath instead of all in classpath.
- Updated Azure Core dependency.

## 1.0.0-beta.4 (2020-04-02)

- Added az namespace info attribute to all outgoing spans for Http Libraries.
- `io.opentelemetry` version update to `0.2.4` API changes.

## 1.0.0-beta.3 (2020-03-06)

- EventHubs: add enqueueTime to Process span links.
- EventHubs: add az namespace attribute to all outgoing spans. 

## 1.0.0-beta.2 (2020-01-07)

- Add `EventHubs.*` properties to attributes of processing spans.
- Remove `Azure` prefix from convenience layer span names.
- Add links for batch send operation in Event Hubs client library. 

This package's
[documentation](https://github.com/Azure/azure-sdk-for-java/blob/azure-core-tracing-opentelemetry_1.0.0-beta.2/sdk/core/azure-core-tracing-opentelemetry/README.md)
and
[samples](https://github.com/Azure/azure-sdk-for-java/blob/azure-core-tracing-opentelemetry_1.0.0-beta.2/sdk/core/azure-core-tracing-opentelemetry/src/samples).

## 1.0.0-beta.1 (2019-11-26)

For details on the Azure SDK for Java (Decemeber 2019 Preview) release refer to the [release announcement](https://aka.ms/azure-sdk-preview5-java).
Version 1.0.0-beta.1 is the first preview of our efforts to provide low level interfaces and helper methods to support tracing for Java client libraries.
This library includes [OpenTelemetry](https://opentelemetry.io/) implementation of the interface.
This library added tracing instrumentation for AMQP and HTTP Java SDK client libraries across different languages and platforms.

This package's
[documentation](https://github.com/Azure/azure-sdk-for-java/blob/azure-core-tracing-opentelemetry_1.0.0-beta.1/sdk/core/azure-core-tracing-opentelemetry/README.md)
and
[samples](https://github.com/Azure/azure-sdk-for-java/blob/azure-core-tracing-opentelemetry_1.0.0-beta.1/sdk/core/azure-core-tracing-opentelemetry/src/samples).
