package unknownuser2.clairclient.options;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class OptionsScreen extends Screen {
    private Screen prevScreen;

    public OptionsScreen(Screen prevScreen) {
        super(Text.of(""));
        this.prevScreen = prevScreen;
        this.init();
    }

    protected void init() {
        addDrawableChild(new ButtonWidget(this.width / 2 - 25, this.height / 2 - 10, 50, 20, Text.of("penis"), (button) -> {
            client.setScreen(prevScreen);
        }));
    }
}
