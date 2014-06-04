package com.example.HF;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Alexander on 28.05.14.
 */
public class HFList {

   /* private ListView listView;
    private View header1;
    private View header2;
    private View footer;
    private Activity activity;*/

    public static final int HEADER_1 = 1;
    public static final int HEADER_2 = 2;
    public static final int FOOTER = 3;

    private View header1;
    private View header2;
    private View footer;
    private int headerCount;
    private ArrayAdapter<String> adapter;


    public void createList(Activity activity, Context context, ListView listView, List<String> content, int headerCount) {
        adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, content);
        this.headerCount = headerCount;

        if (headerCount == 1) {
            header1 = createHeader(activity, "");
            listView.addHeaderView(header1);
        }
        if (headerCount == 2) {
            header1 = createHeader(activity, "");
            header2 = createHeader(activity, "");
            footer = createFooter(activity);
            listView.addHeaderView(header1);
            listView.addHeaderView(header2);
            listView.addFooterView(footer);
        }
        if ((headerCount != 0) && (headerCount > 2))
            throw new IllegalArgumentException("WRONG HEADER NUMBER (MUST BE [0,2])");
        listView.setAdapter(adapter);
    }

    private View createHeader(Activity activity, String text) {
        View v = activity.getLayoutInflater().inflate(R.layout.header, null);
        ((TextView) v.findViewById(R.id.headerText)).setText(text);
        return v;
    }

    public void setHeaderText(int header, String text) {
        switch (header) {
            case HEADER_1:
                if (header1 != null)
                    ((TextView) header1.findViewById(R.id.headerText)).setText(text);
                break;
            case HEADER_2:
                if (header2 != null)
                    ((TextView) header2.findViewById(R.id.headerText)).setText(text);
                break;
            default:
                throw new IllegalArgumentException("WRONG HEADER NUMBER");
        }

    }

    public void setFooterContent(String text) {
        WebView webView = (WebView) footer.findViewById(R.id.footerWebview);
        webView.loadData(text, "text/html", "utf-8");
    }

    private static View createFooter(Activity activity) {
        View v = activity.getLayoutInflater().inflate(R.layout.footer, null);
        return v;
    }

    public void setVisible(int header) {
        switch (header) {
            case HEADER_1:
                if (header1 != null)
                    header1.findViewById(R.id.headerText).setVisibility(View.VISIBLE);
                break;
            case HEADER_2:
                if (header2 != null)
                    header2.findViewById(R.id.headerText).setVisibility(View.VISIBLE);
                break;
            case FOOTER:
                if (footer != null)
                    footer.findViewById(R.id.footerWebview).setVisibility(View.VISIBLE);
                break;
            default:
                throw new IllegalArgumentException("WRONG HEADER NUMBER");
        }
    }
}
