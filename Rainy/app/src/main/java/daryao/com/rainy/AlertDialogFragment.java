package daryao.com.rainy;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by Darya on 2015-09-26.
 */
public class AlertDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle(R.string.context)
                .setMessage(R.string.dialogMessage)
                .setPositiveButton(R.string.ok_button, null);
        AlertDialog dialog = builder.create();
        return dialog;
    }
}
