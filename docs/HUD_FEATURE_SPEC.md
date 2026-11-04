# Apex Client — HUD and client feature specification

This document records the requested feature direction. Every item below is a **planned feature**, not a claim that it currently works in Minecraft.

## HUD widgets

### 1. Keystrokes
- Display WASD and jump input.
- Highlight keys while pressed.
- Compact, readable widget.
- Position and scale customization.

### 2. FPS display
- Show live FPS only when a reliable supported source is available.
- Avoid wasteful polling and background work.
- Never label an estimate as measured FPS.

### 3. Combo counter
- Count consecutive successful hits when reliable combat events are accessible.
- Define reset behavior clearly during implementation.
- No automated attacks, clicks, or gameplay.

### 4. Armor HUD
- Display armor status when the game exposes the required data.

### 5. Potion/effects HUD
- Display active effects and remaining duration when accessible.

### 6. Ping display
- Show network latency only when a trustworthy value can be read.

### 7. Coordinates and direction
- Optional position coordinates.
- Facing direction/compass indicator.

### 8. Custom crosshair
- Configurable appearance, size, and color where supported.

### 9. HUD editor
- Move, resize, and independently enable/disable supported widgets.
- Keep layout readable on different Android screen sizes.

## Visual customization

### 10. On-screen zoom button
- Provide a visible touch button on the in-game screen to activate zoom.
- Default interaction: tap once to toggle zoom on, tap again to turn it off.
- Offer a configurable zoom level where supported.
- Let the player move and resize the button in the HUD editor.
- Match the Apex black/purple/blue visual style without obscuring important controls.
- Do not claim implementation until a supported Bedrock integration path is verified.

### 11. Other visual settings
- View-model settings only if a permitted Bedrock interface supports them.
- Custom colors and purple/blue accent options.
- Lightweight visual effects with performance-friendly defaults and an off switch.

## Client menu

- ClickGUI-style module menu.
- Categories for HUD, visual, and general settings.
- Individual module toggles.
- Save and restore preferences.

## Shared requirements

- Original black and purple/blue Apex styling.
- Android-first and performance-conscious.
- Avoid unnecessary background services and battery use.
- Preserve ordinary multiplayer gameplay and server rules.
- No anti-cheat bypass, aim assistance, automated attacks, or other unfair automation.

## Feasibility gate

The current launcher prototype cannot draw an in-game HUD or read Minecraft input, FPS, ping, coordinates, armor, effects, or combat events. Before implementing each feature, verify a supported integration path for the target Bedrock Android version. Features without a reliable, permitted data source must remain marked unavailable rather than simulated as real values.

Test each implemented feature on-device and check multiplayer compatibility before calling it complete.
