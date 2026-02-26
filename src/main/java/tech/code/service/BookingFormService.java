package tech.code.service;

import java.util.List;

import tech.code.model.BookingForm;

public interface BookingFormService {

	public BookingForm savebBookingFormService(BookingForm bookingForm);
	
	public List<BookingForm> readAllBookingService();
	
	public void deleteBookingService(int id);
}
