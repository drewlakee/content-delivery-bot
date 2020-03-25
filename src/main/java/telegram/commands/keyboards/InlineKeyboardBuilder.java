package telegram.commands.keyboards;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class InlineKeyboardBuilder {
    private InlineKeyboardMarkup keyboardMarkup;
    private List<List<InlineKeyboardButton>> buttons;
    private int line;

    InlineKeyboardBuilder() {
        this.keyboardMarkup = new InlineKeyboardMarkup();
        this.buttons = new ArrayList<>();
        this.line = 0;
        this.buttons.add(new ArrayList<>());
    }

    public InlineKeyboardBuilder addButton(InlineKeyboardButton button) {
        buttons.get(line).add(button);
        return this;
    }

    public InlineKeyboardBuilder nextLine() {
        this.line++;
        this.buttons.add(new ArrayList<>());
        return this;
    }

    public InlineKeyboardMarkup build() {
        return keyboardMarkup.setKeyboard(buttons);
    }
}
