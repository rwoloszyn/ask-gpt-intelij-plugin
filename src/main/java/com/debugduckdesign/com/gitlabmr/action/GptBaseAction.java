package com.debugduckdesign.com.gitlabmr.action;

import com.debugduckdesign.com.gitlabmr.GptApiClient;
import com.debugduckdesign.com.gitlabmr.settings.AppSettingsState;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URISyntaxException;

public abstract class GptBaseAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        AppSettingsState settings = AppSettingsState.getInstance();

        String prompt = this.getPrompt();
        GptApiClient gptClient = new GptApiClient(settings.gptApiKey);
        try {
            String response = gptClient.query(prompt);
            System.out.println(response);

        } catch (URISyntaxException ex) {
            System.out.println("URISyntaxException");
        } catch (IOException ex) {
            System.out.println("IOException");
        }
    }

    public abstract String getPrompt();
}
