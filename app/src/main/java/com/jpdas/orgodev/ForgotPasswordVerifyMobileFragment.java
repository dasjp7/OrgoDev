package com.jpdas.orgodev;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.jetbrains.annotations.NotNull;

public class ForgotPasswordVerifyMobileFragment extends Fragment
{
    private Button next;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        next = view.findViewById(R.id.btn_next_fp_1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = null;
                if (getFragmentManager() != null) {
                    fr = getFragmentManager().beginTransaction();
                }
                if (fr != null) {
                    fr.replace(R.id.forget_password_container, new ForgotPasswordOTPEntry());
                    fr.commit();
                }

            }
        });
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.forgot_password_1, container, false);
        return v;
    }
}
