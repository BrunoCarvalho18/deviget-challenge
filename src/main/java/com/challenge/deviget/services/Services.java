package com.challenge.deviget.services;

public interface Services {
	
	
    Responsee getEndPoint(String endPoint);
    Responsee postEndPoint(String endPoint, Object mensagem);
    Responsee putEndPoint(String endPoint, Object mensagem);
    Responsee deleteEndpoint(String endPoint);

}
