package in.dragons.galaxy.task.playstore;

import com.github.yeriomin.playstoreapi.AndroidAppDeliveryData;

import in.dragons.galaxy.DetailsActivity;
import in.dragons.galaxy.R;
import in.dragons.galaxy.notification.NotificationManagerWrapper;

class BackgroundPurchaseTask extends PurchaseTask {

    @Override
    protected void onPostExecute(AndroidAppDeliveryData deliveryData) {
        super.onPostExecute(deliveryData);
        if (!success()) {
            new NotificationManagerWrapper(context).show(
                    DetailsActivity.getDetailsIntent(context, app.getPackageName()),
                    app.getDisplayName(),
                    context.getString(R.string.error_could_not_download)
            );
        }
    }
}
