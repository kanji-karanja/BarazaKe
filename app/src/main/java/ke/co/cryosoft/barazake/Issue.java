package ke.co.cryosoft.barazake;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Karim K Kanji on 15/06/2017.
 */
public class Issue {
    private static int lastIssueId = 0;
    SQLiteDatabase db;
    private String mName;
    private boolean mOnline;

    public Issue(String name, boolean online) {
        mName = name;
        mOnline = online;
    }

    public static ArrayList<Issue> createIssuesList(int numIssues) {

        ArrayList<Issue> issues = new ArrayList<Issue>();
        for (int i = 1; i <= numIssues; i++) {
            issues.add(new Issue("Issue " + ++lastIssueId, i <= numIssues / 2));
        }
        return issues;
    }

    public String getName() {
        return mName;
    }

    public boolean isOnline() {
        return mOnline;
    }
}
