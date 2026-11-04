# Apex Client — LeviLaunchroid foundation

## Why this foundation

Apex evaluates [LiteLDev/LeviLaunchroid](https://github.com/LiteLDev/LeviLaunchroid) as its Android Bedrock launcher base. It is a full launcher project, not a drop-in Gradle dependency for the original small Compose launcher.

## First milestone

1. Build an Apex-branded debug APK from upstream source.
2. Install it on a real ARM64 Android device.
3. Import/detect the official Minecraft Bedrock installation and test launch.
4. Record the exact Minecraft version, Android version, device ABI, and logs for any failure.
5. Only after reliable launch, evaluate documented native-module integration for individual HUD features.

## Current experimental patch

The workflow changes the upstream application ID to `com.apex.client`, changes the launcher label to Apex Client, removes LeviMC's Google Play Games application ID metadata, and adds a guarded fallback attempt to source `libc++_shared.so` from the launcher APK if Minecraft's APK splits did not provide it.

The native-library fallback is **unverified** until the workflow compiles and the resulting APK is tested on-device. If upstream source changes, the workflow deliberately stops when its expected patch anchors are missing.

## Important limitations

- This build is not yet a verified Apex HUD client.
- A launcher APK alone cannot read private Minecraft game state or draw a native in-game HUD.
- Native modules must use supported documented interfaces and be tested for the exact Bedrock version.
- No add-on packs, behavior packs, resource packs, Script API packs, anti-cheat bypasses, or gameplay automation.
- LeviLaunchroid is Apache-2.0; retain its license and attribution notices and mark modified upstream files when distributing a derivative.

## Upstream references

- [LeviLaunchroid source](https://github.com/LiteLDev/LeviLaunchroid)
- [LeviLamina Android developer guide](https://docs.levimc.org/LeviLamina/developer_guides/android/)
