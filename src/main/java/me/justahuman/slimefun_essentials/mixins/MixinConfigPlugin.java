package me.justahuman.slimefun_essentials.mixins;

import net.fabricmc.loader.api.FabricLoader;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

/**
 * Only applies the mixins under {@code mixins.jei} when JEI is actually installed. Without this,
 * Mixin fails during PREPARE with "@Mixin target ... was not found" and the game crashes on
 * startup for everyone who uses REI (or no recipe viewer) instead of JEI.
 */
public class MixinConfigPlugin implements IMixinConfigPlugin {
    private static final String JEI_MIXIN_PACKAGE = ".mixins.jei.";

    @Override
    public void onLoad(String mixinPackage) {}

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (mixinClassName.contains(JEI_MIXIN_PACKAGE)) {
            return FabricLoader.getInstance().isModLoaded("jei");
        }
        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {}

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
}
