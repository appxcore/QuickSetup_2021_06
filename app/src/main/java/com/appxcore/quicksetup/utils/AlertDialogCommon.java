package com.appxcore.quicksetup.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.appxcore.quicksetup.R;


public class AlertDialogCommon {

    public static void showAlertDialog(final Context context, String title, String message,
                                       String positiveBtnText, String negativeBtnText,
                                       DialogClickListener dialogClickListener) {

        final Dialog dialog = new Dialog(context, R.style.Theme_AppCompat_Dialog_Alert);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialouge_base);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        TextView text = (TextView) dialog.findViewById(R.id.tv_alert_dialogue_message);
        text.setText(message);
        Button dialogButton = (Button) dialog.findViewById(R.id.btn_alert_dialogue_ok);
        Button dialogNo = (Button) dialog.findViewById(R.id.btn_alert_dialogue_no);
        FrameLayout framelayout = (FrameLayout) dialog.findViewById(R.id.framelayout);

        if (negativeBtnText.equals("")) {
            dialogNo.setVisibility(View.GONE);
            framelayout.setVisibility(View.GONE);
        }

        if (positiveBtnText.equals("")) {
            dialogButton.setVisibility(View.GONE);
            framelayout.setVisibility(View.GONE);
        }

        dialogButton.setText(positiveBtnText);
        dialogNo.setText(negativeBtnText);

        dialogButton.setOnClickListener(v -> {
            dialogClickListener.dialogOkBtnClicked("");
            dialog.dismiss();
        });

        dialogNo.setOnClickListener(V -> {
            dialogClickListener.dialogNoBtnClicked("");
            dialog.dismiss();
        });
        dialog.show();

    }

    public interface DialogClickListener {
        void dialogOkBtnClicked(String value);

        void dialogNoBtnClicked(String value);
    }

}
