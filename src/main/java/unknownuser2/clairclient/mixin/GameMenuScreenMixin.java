package unknownuser2.clairclient.mixin;

import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import unknownuser2.clairclient.options.OptionsScreen;

@Mixin(GameMenuScreen.class)
public class GameMenuScreenMixin extends Screen {
    protected GameMenuScreenMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("HEAD"), method = "initWidgets")
    private void initWidgets(CallbackInfo ci) {
         this.addDrawableChild(new ButtonWidget(10, 10, this.client.textRenderer.getWidth("Clair Client config") + 10, 20, Text.of("Clair Client config"), (Button) -> {
             this.client.setScreen(new OptionsScreen(this));
         }));
    }
}
