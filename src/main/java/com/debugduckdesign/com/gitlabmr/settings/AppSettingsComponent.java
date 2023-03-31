package com.debugduckdesign.com.gitlabmr.settings;

import com.intellij.ui.components.JBLabel;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;


public class AppSettingsComponent {

    private final JPanel mainPanel;
    private final JPasswordField gptAPIkeyText = new JPasswordField();

    public AppSettingsComponent() {
        mainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("GPT3 API key: "), gptAPIkeyText, 1, false)
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
    }

    public JPanel getPanel() {
        return mainPanel;
    }

    public JComponent getPreferredFocusedComponent() {
        return gptAPIkeyText;
    }

    @NotNull
    public String getApiKey() {
        return gptAPIkeyText.getPassword().toString();
    }

    public void setApiKey(@NotNull String newText) {
        gptAPIkeyText.setText(newText);
    }
}
