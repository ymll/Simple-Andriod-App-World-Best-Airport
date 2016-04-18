package example.worldbestairport;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Brian on 18/4/2016.
 */
public class BestAirline extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.bestairlinelayout, container, false);
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.title_section3));
        return rootView;
    }
}
