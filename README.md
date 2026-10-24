### SlimefunEssentials
Slimefun Essentials is a minecraft mod dedicated to add support for Slimefun4 items and mechanics to other client sided mods.

### What does it do:
- TODO: rewrite this

### Downloads
- [Github](https://github.com/JustAHuman-xD/SlimefunEssentials/releases)
- [Modrinth](https://modrinth.com/mod/slimefun-essentials)
- [Curseforge](https://www.curseforge.com/minecraft/mc-mods/slimefun-essentials)

### Requirements (Minecraft 26.3)
- Minecraft 26.3, Fabric Loader 0.20.1+, Fabric API, Java 25+

### Dependencies
- Mod Menu (Optional)
- Cloth Config API (Optional)
- Jade (Optional)
- One of the following: (Optional)
  - JEI
  - REI
  - EMI support is not available on 26.x yet: EMI has no release past Minecraft 1.21.1. It will return once EMI updates.

### Building
Run `./gradlew build`; the jar lands in `build/libs/`. Minecraft 26.1+ ships unobfuscated, so the project
uses Mojang's official names directly and Loom's no-remap plugin (`net.fabricmc.fabric-loom`).

### Configuration:
- "recipe_features"
  - Should Slimefun Essentials add support for Slimefun Recipes
  - Requires JEI or REI
  - Requires SlimefunServerEssentials on the server
- TODO: fill out the rest of this