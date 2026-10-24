package me.justahuman.slimefun_essentials.mixins.minecraft;

import net.minecraft.world.entity.ExperienceOrb;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ExperienceOrb.class)
public interface OrbAccessor {
    @Accessor void setValue(int pickingCount);
}
