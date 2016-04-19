package example.worldbestairport;

import android.app.ActionBar;
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
public class BestAirport extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.bestairportlayout, container, false);

        Button btn2016 = (Button) rootView.findViewById(R.id.btn2016);
        Button btn2015 = (Button) rootView.findViewById(R.id.btn2015);
        Button btn2014 = (Button) rootView.findViewById(R.id.btn2014);

        setOnClickListenerForYearButton(btn2016, rootView, R.array.airports2016);
        setOnClickListenerForYearButton(btn2015, rootView, R.array.airports2015);
        setOnClickListenerForYearButton(btn2014, rootView, R.array.airports2014);

        btn2016.performClick();

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(1);
    }

    private void setOnClickListenerForYearButton(Button button, final View rootView, final int dataResourceId) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] data = getResources().getStringArray(dataResourceId);
                ScrollView scrollView = (ScrollView) rootView.findViewById(R.id.scroll_view);
                LinearLayout contentLayout = (LinearLayout) rootView.findViewById(R.id.layout_content);
                TextView txtYearTitle = (TextView) rootView.findViewById(R.id.txt_year_title);

                TextView[] textViewGroup = new TextView[]{
                        (TextView) rootView.findViewById(R.id.first_item_name),
                        (TextView) rootView.findViewById(R.id.first_item_description),
                        (TextView) rootView.findViewById(R.id.second_item_name),
                        (TextView) rootView.findViewById(R.id.second_item_description),
                        (TextView) rootView.findViewById(R.id.third_item_name),
                        (TextView) rootView.findViewById(R.id.third_item_description),
                        (TextView) rootView.findViewById(R.id.fourth_item_name),
                        (TextView) rootView.findViewById(R.id.fourth_item_description),
                };

                txtYearTitle.setText(data[0]);
                for (int i = 0; i+1 < data.length && i < textViewGroup.length; i++) {
                    textViewGroup[i].setText(data[i+1]);
                }

                scrollView.setScrollY(0);
            }
        });
    }
}
