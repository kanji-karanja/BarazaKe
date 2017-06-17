package ke.co.cryosoft.barazake;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Karim K Kanji on 15/06/2017.
 */
public class IssuesAdapter extends
        RecyclerView.Adapter<IssuesAdapter.ViewHolder> {

    public List<Issue> mIssues;
    private Context mContext;

    public IssuesAdapter(Context context, List<Issue> issues) {
        mIssues = issues;
        mContext = context;
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public IssuesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View issuesView = inflater.inflate(R.layout.item_issue, parent, false);

        ViewHolder viewHolder = new ViewHolder(issuesView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(IssuesAdapter.ViewHolder viewHolder, int position) {
        Issue issue = mIssues.get(position);

        TextView textView = viewHolder.nameTextView;
        textView.setText(issue.getName());
        Button button = viewHolder.messageButton;
        button.setText("Message");
    }

    @Override
    public int getItemCount() {
        return mIssues.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public Button messageButton;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.issue_name);
            messageButton = (Button) itemView.findViewById(R.id.message_button);
        }
    }
}

