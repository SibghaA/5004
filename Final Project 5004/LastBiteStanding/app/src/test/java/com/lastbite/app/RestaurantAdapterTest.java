package com.lastbite.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
public class RestaurantAdapterTest {

    @Mock
    private ViewGroup mockParent;
    @Mock
    private LayoutInflater mockInflater;
    @Mock
    private View mockItemView;
    @Mock
    private TextView mockTextView;
    @Mock
    private GameActivity mockGameActivity;

    @Captor
    private ArgumentCaptor<View.OnClickListener> clickListenerCaptor;

    private RestaurantAdapter adapter;
    private List<RestaurantCard> restaurants;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Set up basic restaurant list
        restaurants = new ArrayList<>();
        restaurants.add(new RestaurantCard(
                "Test Restaurant",
                "Test Cuisine",
                "4.5",
                "123 Test St",
                "Dinner"
        ));

        adapter = new RestaurantAdapter(restaurants);

        // Mock layout inflation
        when(mockParent.getContext()).thenReturn(mockGameActivity);
        when(mockInflater.inflate(eq(R.layout.restaurant_card), any(ViewGroup.class), eq(false)))
                .thenReturn(mockItemView);
        when(mockItemView.findViewById(anyInt())).thenReturn(mockTextView);
    }

    @Test
    public void testConstructorWithValidList() {
        assertNotNull("Adapter should be created with valid list", adapter);
        assertEquals("Item count should match list size", 1, adapter.getItemCount());
    }

    @Test
    public void testConstructorWithEmptyList() {
        adapter = new RestaurantAdapter(new ArrayList<>());
        assertEquals("Empty list should have 0 items", 0, adapter.getItemCount());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorWithNullList() {
        adapter = new RestaurantAdapter(null);
    }

    @Test
    public void testGetItemCount() {
        // Test with multiple items
        restaurants.add(new RestaurantCard("R2", "C2", "4.0", "Address", "Lunch"));
        assertEquals("Item count should match list size", 2, adapter.getItemCount());

        // Test after clearing
        restaurants.clear();
        assertEquals("Empty list should have 0 items", 0, adapter.getItemCount());
    }

    @Test
    public void testOnBindViewHolder() {
        RestaurantAdapter.RestaurantViewHolder holder = mock(RestaurantAdapter.RestaurantViewHolder.class);
        holder.restaurantName = mockTextView;
        holder.cuisineType = mockTextView;
        holder.rating = mockTextView;
        holder.address = mockTextView;
        holder.suggestedFor = mockTextView;

        adapter.onBindViewHolder(holder, 0);

        verify(holder.restaurantName).setText("Test Restaurant");
        verify(holder.cuisineType).setText("Test Cuisine");
        verify(holder.rating).setText("4.5");
        verify(holder.address).setText("123 Test St");
        verify(holder.suggestedFor).setText("Suggested for: Dinner");
    }

    @Test
    public void testOnBindViewHolderWithEmptyFields() {
        RestaurantCard emptyCard = new RestaurantCard("", "", "", "", "");
        restaurants.clear();
        restaurants.add(emptyCard);

        RestaurantAdapter.RestaurantViewHolder holder = mock(RestaurantAdapter.RestaurantViewHolder.class);
        holder.restaurantName = mockTextView;
        holder.cuisineType = mockTextView;
        holder.rating = mockTextView;
        holder.address = mockTextView;
        holder.suggestedFor = mockTextView;

        adapter.onBindViewHolder(holder, 0);

        verify(holder.restaurantName).setText("");
        verify(holder.cuisineType).setText("");
        verify(holder.rating).setText("");
        verify(holder.address).setText("");
        verify(holder.suggestedFor).setText("Suggested for: ");
    }

    @Test
    public void testRemoveItem() {
        // Add multiple items
        restaurants.add(new RestaurantCard("R2", "C2", "4.0", "Address", "Lunch"));
        restaurants.add(new RestaurantCard("R3", "C3", "3.5", "Address", "Breakfast"));

        int initialSize = adapter.getItemCount();
        adapter.removeItem(1);

        assertEquals("Size should decrease by 1", initialSize - 1, adapter.getItemCount());
        assertNotEquals("Second restaurant should be removed", "R2",
                restaurants.get(1).getName());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveItemWithInvalidIndex() {
        adapter.removeItem(5); // Invalid index
    }

    @Test
    public void testClickListener() {
        // Set up mock view and context
        View mockView = mock(View.class);
        when(mockView.getContext()).thenReturn(mockGameActivity);

        // Create adapter and capture click listener
        adapter.onCreateViewHolder(mockParent, 0);
        verify(mockItemView).setOnClickListener(clickListenerCaptor.capture());

        // Get the captured click listener and simulate click
        View.OnClickListener clickListener = clickListenerCaptor.getValue();
        clickListener.onClick(mockView);

        // Verify openInMaps was called
        verify(mockGameActivity).openInMaps(any(RestaurantCard.class));
    }

    @Test
    public void testClickListenerWithNonGameActivity() {
        // Test with a different context type
        Context mockContext = mock(Context.class);
        View mockView = mock(View.class);
        when(mockView.getContext()).thenReturn(mockContext);

        // Create adapter and capture click listener
        adapter.onCreateViewHolder(mockParent, 0);
        verify(mockItemView).setOnClickListener(clickListenerCaptor.capture());

        // Get the captured click listener and simulate click
        View.OnClickListener clickListener = clickListenerCaptor.getValue();
        clickListener.onClick(mockView);

        // Verify openInMaps was never called since it's not a GameActivity
        verify(mockGameActivity, never()).openInMaps(any(RestaurantCard.class));
    }

    @Test
    public void testViewHolderInitialization() {
        View mockItemView = mock(View.class);
        when(mockItemView.findViewById(anyInt())).thenReturn(mock(TextView.class));

        RestaurantAdapter.RestaurantViewHolder holder = new RestaurantAdapter.RestaurantViewHolder(mockItemView);

        assertNotNull("Restaurant name TextView should be initialized", holder.restaurantName);
        assertNotNull("Cuisine type TextView should be initialized", holder.cuisineType);
        assertNotNull("Rating TextView should be initialized", holder.rating);
        assertNotNull("Address TextView should be initialized", holder.address);
        assertNotNull("Suggested for TextView should be initialized", holder.suggestedFor);
    }

    @Test
    public void testOnCreateViewHolder() {
        // Set up the mock inflater in the context
        when(mockParent.getContext()).thenReturn(mockGameActivity);
        LayoutInflater mockInflater = mock(LayoutInflater.class);
        when(LayoutInflater.from(mockGameActivity)).thenReturn(mockInflater);
        when(mockInflater.inflate(eq(R.layout.restaurant_card), any(ViewGroup.class), eq(false)))
                .thenReturn(mockItemView);
        when(mockItemView.findViewById(anyInt())).thenReturn(mockTextView);

        RestaurantAdapter.RestaurantViewHolder holder = adapter.onCreateViewHolder(mockParent, 0);

        assertNotNull("ViewHolder should not be null", holder);
        assertNotNull("ViewHolder's itemView should not be null", holder.itemView);
    }
}