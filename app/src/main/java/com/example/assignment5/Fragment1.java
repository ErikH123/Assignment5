package com.example.assignment5;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {
    private Fragment1Listener listener;
    private EditText editText;
    private Button button;
    private TextView textView;

    public interface Fragment1Listener {
        void onInput1Sent(CharSequence input);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1, container, false);

        editText = v.findViewById(R.id.editText);
        button = v.findViewById(R.id.button);
        textView = v.findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = editText.getText();
                listener.onInput1Sent(input);
            }
        });

        return v;
    }

    public void updateTextView(CharSequence uusi){
        textView.setText(uusi);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Fragment1Listener){
            listener = (Fragment1Listener) context;
        }
        else{
            throw new RuntimeException(context.toString() +
                    "must implement Fragment1Listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
