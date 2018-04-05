package com.example.durma.androidtabb;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by durma on 27.12.17..
 */

public class Tab3Fragment extends Fragment {
    private static final String TAG="Tab3Fragment";

    private Button btnTEST;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab3_fragmnet, container, false);

        btnTEST = (Button) view.findViewById(R.id.btnTest3);

        btnTEST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Testing btn3 click", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
