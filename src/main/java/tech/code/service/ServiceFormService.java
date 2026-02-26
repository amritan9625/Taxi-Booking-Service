package tech.code.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tech.code.model.ServiceForm;

public interface ServiceFormService {

	public ServiceForm addService(ServiceForm serviceForm, MultipartFile multipartFile) throws Exception;
	
	public List<ServiceForm> readAllServices();

	public void deleteBookingService(int id);
}
