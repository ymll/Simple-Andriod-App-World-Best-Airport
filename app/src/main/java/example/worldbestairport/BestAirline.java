package example.worldbestairport;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by Brian on 18/4/2016.
 */
public class BestAirline extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.bestairlinelayout, container, false);

        Button btn2016 = (Button) rootView.findViewById(R.id.btn2016);
        Button btn2015 = (Button) rootView.findViewById(R.id.btn2015);
        Button btn2014 = (Button) rootView.findViewById(R.id.btn2014);
        TextView txtComingSoon = (TextView) rootView.findViewById(R.id.txt_coming_soon);

        setOnClickListenerForComingYearButton(btn2016, rootView);
        setOnClickListenerForYearButton(btn2015, rootView, R.array.airlines2015);
        setOnClickListenerForYearButton(btn2014, rootView, R.array.airlines2014);

        btn2016.performClick();

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(2);
    }

    private void setOnClickListenerForComingYearButton(Button button, final View rootView) {
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                LinearLayout contentLayout = (LinearLayout) rootView.findViewById(R.id.layout_content);
                TextView txtComingSoon = (TextView) rootView.findViewById(R.id.txt_coming_soon);

                txtComingSoon.setVisibility(View.VISIBLE);
                contentLayout.setVisibility(View.GONE);
            }
        });
    }

    private void setOnClickListenerForYearButton(Button button, final View rootView, final int dataResourceId) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] data = getResources().getStringArray(dataResourceId);
                ScrollView scrollView = (ScrollView)rootView.findViewById(R.id.scroll_view);
                LinearLayout contentLayout = (LinearLayout) rootView.findViewById(R.id.layout_content);
                TextView txtComingSoon = (TextView) rootView.findViewById(R.id.txt_coming_soon);

                TextView[] textViewGroup = new TextView[]{
                    (TextView)rootView.findViewById(R.id.first_item_name),
                    (TextView)rootView.findViewById(R.id.first_item_description),
                    (TextView)rootView.findViewById(R.id.second_item_name),
                    (TextView)rootView.findViewById(R.id.second_item_description),
                    (TextView)rootView.findViewById(R.id.third_item_name),
                    (TextView)rootView.findViewById(R.id.third_item_description),
                };

                for (int i=0; i<data.length && i<textViewGroup.length; i++) {
                    textViewGroup[i].setText(data[i]);
                }

                txtComingSoon.setVisibility(View.GONE);
                contentLayout.setVisibility(View.VISIBLE);
                scrollView.setScrollY(0);
            }
        });
    }
}
