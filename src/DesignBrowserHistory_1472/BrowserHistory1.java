package DesignBrowserHistory_1472;

import java.util.*;

/**
 * $$ Constructor Time Complexity: O(1)
 * $$ visit() Time Complexity: O(1)
 * $$ back() Time Complexity: O(1)
 * $$ forward() Time Complexity: O(1)
 */
public class BrowserHistory1 {
    List<String> history = new ArrayList<>();
    int last = 0;
    int i = 0;

    public BrowserHistory1(String homepage) {
        this.history.add(homepage);
    }

    public void visit(String url) {
        if (i+1 == this.history.size()) {
            this.history.add(url);
        } else {
            this.history.set(i+1, url);
        }
        i++;
        last = i;
    }

    public String back(int steps) {
        i = Math.max(0, i-steps);
        return this.history.get(i);
    }

    public String forward(int steps) {
        i = Math.min(last, i+steps);
        return this.history.get(i);
    }
}