package com.aranibar.homeservice.viewcontrollers.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnetworking.widget.ANImageView;
import com.aranibar.homeservice.R;
import com.aranibar.homeservice.viewcontrollers.models.Customer;

import java.util.List;

public class SpecialistAdapter extends RecyclerView.Adapter<SpecialistAdapter.ViewHolder> {

    List<Customer> customers;

    public SpecialistAdapter(List<Customer> customers){
        this.customers = customers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @NonNull
    @Override
    public SpecialistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SpecialistAdapter.ViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_specialist, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SpecialistAdapter.ViewHolder holder, int position) {
        holder.updateViews(customers.get(position));
    }

    @Override
    public int getItemCount() {
        return customers.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private Customer customer;
        private TextView names;
        private TextView specialty;
        private TextView description;
        private TextView address;
        private TextView phone;
        private ANImageView image;


        public ViewHolder(View itemView) {
            super(itemView);
            names = (TextView) itemView.findViewById(R.id.namesTextView);
            specialty = (TextView) itemView.findViewById(R.id.specialtyTextView);
            description = (TextView) itemView.findViewById(R.id.descriptionTextView);
            address = (TextView) itemView.findViewById(R.id.addressTextView);
            phone = (TextView) itemView.findViewById(R.id.phoneTextView);
            image = (ANImageView) itemView.findViewById(R.id.pictureCardView);
        }

        public void updateViews(Customer customer) {
            this.customer = customer;
            names.setText(customer.getName() + " " + customer.getLastName());
            specialty.setText(customer.getSpecialty().getName());
            description.setText(customer.getDescription());
            address.setText(customer.getAddress());
            phone.setText(customer.getNumberPhone());
            image.setImageUrl(customer.getImgURL());
            image.setDefaultImageResId(R.drawable.ic_logo_background);
        }
    }
}
