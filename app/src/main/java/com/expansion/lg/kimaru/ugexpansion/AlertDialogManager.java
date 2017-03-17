package com.expansion.lg.kimaru.ugexpansion;

import android.content.Context;
import android.content.DialogInterface;
import android.icu.text.DateFormat;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface.OnClickListener;


/**
 * Created by kimaru on 3/9/17.
 */

public class AlertDialogManager {

    /**
     * Fn to display simple alert Dialog
     * @param context -- Application Context
     * @param title -- Alter Dialog Title
     * @param message - Alert Msg
     * @param status - success/failure (Used to set teh correct Icon)
     *               - pass null if no Icon is needed
     */

    public void showAlertDialog(Context context, String title, String message, Boolean status){
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();

        //set the title, I almost wrote 'Tithe', lakini  :D
        alertDialog.setTitle(title);

        //set the message
        alertDialog.setMessage(message);

        //set the icon only if status is not null
        if(status != null) {
            // Setting alert dialog icon
            alertDialog.setIcon((status) ? R.drawable.ic_menu_gallery : R.drawable.ic_menu_send);
        }
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Retry", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alertDialog.show();
    }
}
