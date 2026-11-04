# Apex Client

Apex Client is an Android-first Minecraft Bedrock launcher experiment built around the upstream [LeviLaunchroid](https://github.com/LiteLDev/LeviLaunchroid) project.

## Current milestone

**Milestone 1: establish a reliable Android Bedrock launcher foundation.**

The experimental workflow clones LeviLaunchroid at build time, applies Apex's Android package identity, and builds a debug APK. This is a launcher migration experiment—not a completed in-game client or HUD.

## Product direction

- Standalone Android APK
- Apex purple/blue visual identity and supplied app icon
- Dark, polished launcher UI inspired by the broad layout style of Lunar Client (original implementation and assets)
- Minecraft Bedrock launch and version compatibility testing
- Performance-conscious design

## Planned client features

The requested feature ideas include keystrokes, FPS, combo, armor/effects, ping, coordinates, a custom crosshair, movable HUD widgets, and a zoom control. None should be represented as implemented until there is a supported integration path and real-device verification.

LeviLaunchroid provides a possible native-module foundation, but it does not automatically implement these features. Each one needs compatibility testing against the exact Bedrock version and device. No fake live game data.

## Scope and fair play

- No behavior packs, resource packs, Script API packs, or separate add-on files.
- No anti-cheat bypasses, aim assistance, automated attacks, or other unfair gameplay automation.
- Use supported launcher/native-module interfaces; no unauthorized process injection or bypassing Android protections.
- Preserve upstream Apache-2.0 license and attribution notices when redistributing modified upstream code.

## Build

Open **Actions → Apex Client — LeviLaunchroid experimental APK → Run workflow**.

The workflow is manual-only to avoid a build queue on every documentation or source change. A successful build proves only that the launcher APK compiles; it does not prove Minecraft starts successfully or that HUD features work.
