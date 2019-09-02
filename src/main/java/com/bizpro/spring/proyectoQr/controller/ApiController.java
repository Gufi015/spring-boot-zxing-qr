package com.bizpro.spring.proyectoQr.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
/*
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bizpro.spring.proyectoQr.model.Clientes;
import com.bizpro.spring.proyectoQr.model.GenerarQr;
import com.bizpro.spring.proyectoQr.model.Productos;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
public class ApiController {

	@RequestMapping(value = "/productos", method = RequestMethod.GET)
	public @ResponseBody ArrayList<Productos> getProductos() {

		ArrayList<Productos> elementos = new ArrayList<>();

		elementos.add(new Productos(1l, "Telefono", "Telefono de ultima generación", 500.50, "Telefonia",
				"https://www.telcel.com/content/dam/telcelcom/dispositivos/Huawei/DRA-LX3/imagenes/negro/frontal.jpg/jcr:content/renditions/cq5dam.web.250.470.jpeg"));

		elementos.add(new Productos(2l, "PAN", "Pan del diario", 550, "Comida",
				"https://cdn.pixabay.com/photo/2010/12/13/10/14/background-2561__340.jpg"));

		elementos.add(new Productos(3l, "Vino", "Vino reposado en barricas de roble", 5500, "Licores",
				"https://cdn.pixabay.com/photo/2016/10/31/19/38/wine-1786539__340.jpg"));

		elementos.add(new Productos(4l, "Camara Profecional", "Camara profecional Reflex de 45px lente de 55-18mm",
				5500, "Electronics", "https://cdn.pixabay.com/photo/2014/08/29/14/53/photo-431119__340.jpg"));

		elementos.add(new Productos(5l, "Kindle", "Moderno lector de libros digitales", 5100, "Electronics",
				"https://cdn.pixabay.com/photo/2014/07/01/12/37/kindle-381242__340.jpg"));

		elementos.add(new Productos(6l, "Dron", "Dron con camara integrada de la marca DronPatito", 5500, "Electronics",
				"https://cdn.pixabay.com/photo/2016/09/10/11/42/quadrocopter-1658967__340.png"));

		elementos.add(new Productos(7l, "Sala Comedor", "Comoda sala para decorar la casa", 15500, "Muebles",
				"https://cdn.pixabay.com/photo/2017/08/06/11/09/interior-2591368__340.jpg"));

		elementos.add(new Productos(8l, "Smart Tv", "Televisión con 50 pulgadas Led", 8800, "Electronics",
				"https://image.shutterstock.com/image-photo/4k-monitor-isolated-on-white-260nw-357968483.jpg"));

		elementos.add(new Productos(9l, "Audi", "Sorprendente auto carisimo por sierto", 555500, "Autos",
				"https://cdn.pixabay.com/photo/2015/01/19/13/51/car-604019__340.jpg"));

		elementos.add(new Productos(10l, "Ropa", "Outfit Millenials", 5500, "Ropa y Accesorios",
				"https://cdn.pixabay.com/photo/2015/09/02/12/28/fashion-918446__340.jpg"));

		elementos.add(new Productos(11l, "Camisas", "Lindas camisas para ir a la oficina bien Godin", 5500, "Ropa",
				"https://cdn.pixabay.com/photo/2014/08/26/21/48/shirts-428600__340.jpg"));

		elementos.add(new Productos(12l, "Mac de escritorio", "Excelente computadora de escritorio", 55500,
				"Electronics", "https://cdn.pixabay.com/photo/2017/10/15/09/33/desk-2852986__340.jpg"));

		elementos.add(new Productos(13l, "Xbox 360", "Consola de Juegos para pasar horas de diversion", 19000,
				"Electronics", "https://cdn.pixabay.com/photo/2016/02/14/21/09/xbox-1200296__340.jpg"));

		elementos.add(new Productos(14l, "PlayStation 4", "Increible consola de videojuegos", 19500, "Electronics",
				"https://cdn.pixabay.com/photo/2017/05/19/14/09/ps4-2326616__340.jpg"));

		elementos.add(new Productos(15l, "Dulces tradicionales", "Ricos dulces para compartir", 5500, "Comida",
				"https://image.shutterstock.com/image-photo/mexican-traditional-candies-colorful-assorted-260nw-655469329.jpg"));

		return elementos;
	}

	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	public @ResponseBody ArrayList<Clientes> getClientes() {
		ArrayList<Clientes> elementos = new ArrayList<>();
		elementos.add(new Clientes(1l, "Santander", 999932));
		elementos.add(new Clientes(2l, "BizPro", 999932));
		elementos.add(new Clientes(3l, "BizProBPM", 999932));
		elementos.add(new Clientes(4l, "Banorte", 999932));
		elementos.add(new Clientes(5l, "Telcel", 999932));
		elementos.add(new Clientes(6l, "Bimbo", 999932));
		elementos.add(new Clientes(7l, "Pepsi", 999932));
		elementos.add(new Clientes(8l, "Izzi", 999932));
		elementos.add(new Clientes(9l, "Coca cola", 999932));
		elementos.add(new Clientes(10l, "Otro", 999932));

		return elementos;
	}

	@PostMapping(value = "/generarQr")
	@ResponseStatus(HttpStatus.OK)
	public Map<String, Object> newRegistro(@RequestBody GenerarQr qr) throws WriterException, IOException {
		HashMap<String, Object> map = new HashMap<>();
		map.put("qr", generarQR(qr));
		map.put("status", HttpStatus.OK);
		return map;

	}

	private String generarQR(GenerarQr qr) throws WriterException, IOException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		BitMatrix bitMatrix = new MultiFormatWriter().encode("Total: " + qr.getTotal() + "\nNombreProducto: "
				+ qr.getLista() + "\nNumero de Cuenta: " + qr.getNumeroCuenta() + " \nNombre: " + qr.getNombre(),
				BarcodeFormat.QR_CODE, 250, 250);
		MatrixToImageWriter.writeToStream(bitMatrix, MediaType.IMAGE_PNG.getSubtype(), baos, new MatrixToImageConfig());
		byte[] data = baos.toByteArray();
		String encodedString = Base64.getEncoder().encodeToString(data);

		return encodedString;

	}

}
