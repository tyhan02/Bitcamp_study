package handler;

import util.ActionL;
import util.BPrompt;

public class HeaderL implements ActionL {
    @Override
    public void service(BPrompt prompt) {
        System.out.println("=============================[비트캠프!]==");
    }
}