# Apex Client

Apex Client is an Android-first Minecraft Bedrock launcher experiment built around the LeviMC Android launcher codebase.

## Current milestone

**Milestone 1: establish a reliable Android Bedrock launcher foundation.**

The repository keeps Apex's own app scaffold and branding at the root. The full upstream LeviLauncher Android source can be imported into `upstream/LeviLauncher-Android/` without creating a fork or overwriting Apex's existing files.

## Import LeviLauncher source

1. Open **Actions** in this repository.
2. Select **Import LeviLauncher Android source**.
3. Press **Run workflow** on the `main` branch.
4. When it finishes, the complete upstream source (including initialized submodule contents) will be committed under `upstream/LeviLauncher-Android/`.

The import preserves the Apex root project and its docs. The upstream source keeps its own Apache-2.0 license and bundled third-party notices. The upstream debug API-key file is deliberately not copied.

**Important:** importing the source does not yet make it the active root Android build. It is staged for inspection and integration; no APK build or device launch is claimed by this import step.

## Product direction

- Standalone Android APK
- Apex purple/blue visual identity and supplied app icon
- Dark, polished launcher UI inspired by the broad layout style of Lunar Client (original implementation and assets)
- Minecraft Bedrock launch and version compatibility testing
- Performance-conscious design

## Planned client features

The requested feature ideas include keystrokes, FPS, combo, armor/effects, ping, coordinates, a custom crosshair, movable HUD widgets, and a zoom control. None should be represented as implemented until there is a supported integration path and real-device verification.

LeviLauncher provides a possible native-module foundation, but it does not automatically implement these features. Each one needs compatibility testing against the exact Bedrock version and device. No fake live game data.

## Scope and fair play

- No behavior packs, resource packs, Script API packs, or separate add-on files.
- No anti-cheat bypasses, aim assistance, automated attacks, or other unfair gameplay automation.
- Use supported launcher/native-module interfaces; no unauthorized process injection or bypassing Android protections.
- Preserve upstream Apache-2.0 license and attribution notices when redistributing modified upstream code.

## Build

The root project still has its existing experimental build workflow. The imported LeviLauncher source is not wired into that workflow yet.
