package me.justahuman.slimefun_essentials.mixins.jei;

import me.justahuman.slimefun_essentials.compat.jei.JeiReloader;
import mezz.jei.fabric.startup.ClientLifecycleHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ClientLifecycleHandler.class, remap = false)
public abstract class ClientLifecycleHandlerMixin implements JeiReloader {
    // JEI ships optimised bytecode that reuses local slot 0 inside the constructor, which breaks a
    // constructor-RETURN injection with a VerifyError. registerEvents() runs once right after
    // construction and is a plain instance method, so slot 0 is guaranteed to be `this` at HEAD.
    @Inject(method = "registerEvents", at = @At("HEAD"))
    public void onRegisterEvents(CallbackInfo ci) {
        JeiReloader.instance.set(this);
    }

    @Override
    public void slimefunEssentials$reloadJei() {
        restartJei();
    }

    @Shadow public abstract void restartJei();
}
