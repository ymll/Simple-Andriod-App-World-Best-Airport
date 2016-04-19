package example.worldbestairport;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Brian on 18/4/2016.
 */
public class BestAirline extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.bestairlinelayout, container, false);
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.title_section3));

        Button btn2016 = (Button)rootView.findViewById(R.id.btn2016);
        Button btn2015 = (Button)rootView.findViewById(R.id.btn2015);
        Button btn2014 = (Button)rootView.findViewById(R.id.btn2014);

        setOnClickListenerForYearButton(btn2015, rootView, R.array.airlines2015);
        setOnClickListenerForYearButton(btn2014, rootView, R.array.airlines2014);

        return rootView;
    }

    private void setOnClickListenerForYearButton(Button button, final View rootView, final int dataResourceId) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] data = getResources().getStringArray(dataResourceId);

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
            }
        });
    }
}
