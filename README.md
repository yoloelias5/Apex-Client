# Apex Client

Apex Client is an Android-first launcher project for Minecraft Bedrock, with an original purple/blue visual identity and a clean client-style interface inspired by the general layout conventions of desktop game clients.

## Current status

This repository starts from the previous Android launcher prototype. It is a launcher foundation, **not yet an in-game Minecraft modification**. A successful APK build only confirms that the Android app compiles.

## Project goals

- Standalone Android APK
- Apex icon and purple/blue branding
- Clean, dark, Lunar-inspired launcher layout (original implementation and assets)
- Detect and launch the installed Minecraft Bedrock app
- Lightweight settings and launcher preferences
- Investigate supported, permitted integration options before promising any in-game HUD

## Requested client features

Planned ideas include keystrokes, FPS, combo, armor/effects, ping, coordinates, custom crosshair, movable HUD widgets, and a zoom control. These are **not implemented**. A normal Android launcher cannot read Minecraft's private game state or draw a native in-game HUD merely by launching the game. Each feature needs a verified supported integration path; unavailable data must never be faked.

## Fair play

No anti-cheat bypasses, aim assistance, automated attacks, or other unfair gameplay automation. No claim of multiplayer compatibility until tested.

## Build

GitHub Actions builds a debug APK on pushes to `main` and manual workflow dispatch. The artifact is a debug build for testing, not a Play Store release.
