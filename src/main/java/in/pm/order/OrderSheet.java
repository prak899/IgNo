package in.pm.order;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import in.pm.order.databinding.OrderBottomsheetBinding;

public class OrderSheet extends BottomSheetDialogFragment {

    private OrderBottomsheetBinding binding;

    private OrderSheet.DialogClickListener listener;

    private Boolean profileSet;

    public OrderSheet(Boolean profileSet) {
        this.profileSet = profileSet;
    }


    public interface DialogClickListener {
        void onDialogGalleryClick();
        void onDialogCameraClick();
        void onDialogRemoveClick();
    }

    public void setDialogClickListener(OrderSheet.DialogClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = OrderBottomsheetBinding.inflate(inflater, container, false);

        if (profileSet){
            binding.removeIv.setVisibility(View.VISIBLE);
            binding.removeTv.setVisibility(View.VISIBLE);
        } else {
            binding.removeIv.setVisibility(View.VISIBLE);
            binding.removeTv.setVisibility(View.VISIBLE);
        }

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.removeIv.setOnClickListener(v -> {
            listener.onDialogRemoveClick();
            dismiss();
        });

        binding.removeTv.setOnClickListener(v -> {
            listener.onDialogRemoveClick();
            dismiss();
        });

        binding.galleryImgView.setOnClickListener(v -> {
            listener.onDialogGalleryClick();
            dismiss();
        });

        binding.galleryTv.setOnClickListener(v -> {
            listener.onDialogGalleryClick();
            dismiss();
        });

        binding.cameraImgView.setOnClickListener(v -> {
            listener.onDialogCameraClick();
            dismiss();
        });

        binding.cameraTv.setOnClickListener(v -> {
            listener.onDialogCameraClick();
            dismiss();
        });

    }
}
