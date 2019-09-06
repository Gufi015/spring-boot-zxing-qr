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

		elementos.add(new Productos(1l, "Pepsi", "Pepsi, 12 - 12 FL OZ (355 mL), Cans", 20, "Bebidas",
				"https://www.pepsico.com/images/album/product-information/240_pepsi_12oz.png?sfvrsn=9602ed47_2", 100));

		elementos.add(new Productos(2l, "Papas", "Lay's, Barbecue Flavored, Potato Chips, Net Wt 23 OZ (1 LB. 7 OZ) 652 g, Bag", 20, "Botana",
				"https://www.pepsico.com/images/album/product-information/lays.png?sfvrsn=27679900_2", 100));

		elementos.add(new Productos(3l, "Mountain Dew", "Mountain Dew, Net Wt 23 OZ (1 LB. 7 OZ) 652 g, Bag", 30, "Bebidas",
				"https://www.pepsico.com/images/album/product-information/mtdew_20oz.png?sfvrsn=8b173a59_2", 100));

		elementos.add(new Productos(4l, "Doritos", "Barbecue Flavored, Potato Chips, Net Wt 23 OZ (1 LB. 7 OZ) 652 g, Bag",
				55.00, "Botana", "https://www.pepsico.com/images/album/product-information/doritos-nc.png?sfvrsn=81893cca_2", 100));

		elementos.add(new Productos(5l, "Gatorade", "Gatorade, 12 - 12 FL OZ (355 mL), Cans", 25, "Bebidas",
				"https://www.pepsico.com/images/album/product-information/gat_hero_28oz_ml_or_refl.png?sfvrsn=bf51734f_2", 100));

		elementos.add(new Productos(6l, "Quaker", "Avena para un buen desayuno balanceado", 25, "Alimentos",
				"https://www.pepsico.com/images/album/product-information/sqo-new.png?sfvrsn=9bef5177_2", 100));

		elementos.add(new Productos(7l, "Chetos", "Chetos, Barbecue Flavored, Potato Chips, Net Wt 23 OZ (1 LB. 7 OZ) 652 g, Bag ", 20, "Botana",
				"https://www.pepsico.com/images/album/product-information/cheetos-crunchy-(1).png?sfvrsn=82c3bbff_2", 100));

		elementos.add(new Productos(8l, "Tostitos", "Tostitos, Barbecue Flavored, Potato Chips, Net Wt 23 OZ (1 LB. 7 OZ) 652 g, Bag", 18, "Botana",
				"https://www.pepsico.com/images/album/product-information/tostitos-rstc.png?sfvrsn=55ecd150_2", 100));

		elementos.add(new Productos(9l, "Fritos", "Fritos, Barbecue Flavored, Potato Chips, Net Wt 23 OZ (1 LB. 7 OZ) 652 g, Bag ", 20, "Botana",
				"https://www.pepsico.com/images/album/product-information/fritos-original.png?sfvrsn=f38366c1_2", 100));

		elementos.add(new Productos(10l, "Mirinda", "Pepsi, 12 - 12 FL OZ (355 mL), Cans", 20, "Bebidas",
				"https://www.pepsico.com/images/album/product-information/mirinda_orange_refreshed.png?sfvrsn=4197944c_2", 100));

		elementos.add(new Productos(11l, "Nut Harvest", "Nut Harvest, Barbecue Flavored, Net Wt 23 OZ (1 LB. 7 OZ) 652 g, Bag ", 30, "Botana",
				"https://www.pepsico.com/images/album/product-information/nut-harvest-mixed-nuts.png?sfvrsn=f15dbeb1_2", 100));

		elementos.add(new Productos(12l, "Smarth food", "Smarth food, Net Wt 23 OZ (1 LB. 7 OZ) 652 g, Bag ", 20,
				"Alimentos", "https://www.pepsico.com/images/album/product-information/smartfood-black-bag.png?sfvrsn=80243dbe_2", 100));

		elementos.add(new Productos(13l, "Sun Chips", "sun chips, Barbecue Flavored, Potato Chips, Net Wt 23 OZ (1 LB. 7 OZ) 652 g, Bag ", 19,
				"Botana", "https://www.pepsico.com/images/album/product-information/sunchips-original.png?sfvrsn=10926eb_2", 100));

		elementos.add(new Productos(14l, "Bare Snack", "Bare Snack, Barbecue Flavored, Potato Chips, Net Wt 23 OZ (1 LB. 7 OZ) 652 g, Bag", 19, "Botana",
				"https://www.pepsico.com/images/album/product-information/bare-apple-3-4oz-fuji-no-holes01.png?sfvrsn=a5498670_2", 100));

		elementos.add(new Productos(15l, "Sabritones", "Sabritones, Barbecue Flavored, Potato Chips, Net Wt 23 OZ (1 LB. 7 OZ) 652 g, Bag", 20, "Botana",
				"https://www.pepsico.com/images/album/product-information/sabritones-chili-and-lime.png?sfvrsn=b6bfc025_2", 100));

		elementos.add(new Productos(15l, "Santitas", "Santitas, Barbecue Flavored, Potato Chips, Net Wt 23 OZ (1 LB. 7 OZ) 652 g, Bag", 20, "Botana",
				"https://www.pepsico.com/images/album/product-information/santitas.png?sfvrsn=45cb9fc1_2", 100));
		
		elementos.add(new Productos(15l, "Matador", "Matador, Barbecue Flavored, Potato Chips, Net Wt 23 OZ (1 LB. 7 OZ) 652 g, Bag", 20, "Botana",
				"https://www.pepsico.com/images/album/product-information/matador-3oz_original.png?sfvrsn=88a079f7_2", 100));
		
		elementos.add(new Productos(15l, "Aquafina", "Aquafina, 12 - 12 FL OZ (355 mL)", 10, "Bebida",
				"https://www.pepsico.com/images/album/product-information/aquafina_20oz.png?sfvrsn=23a654ac_2", 100));
		
		elementos.add(new Productos(15l, "Ruffles", "Ruffles de Queso, Barbecue Flavored, Potato Chips, Net Wt 23 OZ (1 LB. 7 OZ) 652 g, Bag", 20, "Botana",
				"https://www.pepsico.com/images/album/product-information/ruffles-xxl-cheddar-sour-cream-(1).png?sfvrsn=7891b35e_2", 100));
		
		elementos.add(new Productos(15l, "Sabritones", "Sabritones, Barbecue Flavored, Potato Chips, Net Wt 23 OZ (1 LB. 7 OZ) 652 g, Bag", 20, "Botana",
				"https://www.pepsico.com/images/album/product-information/sabritones-chili-and-lime.png?sfvrsn=b6bfc025_2", 100));
		
		return elementos;
	}

	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	public @ResponseBody ArrayList<Clientes> getClientes() {
		ArrayList<Clientes> elementos = new ArrayList<>();
		elementos.add(new Clientes(1l, "Walmart", 999932));
		elementos.add(new Clientes(2l, "Soriana", 999932));
		elementos.add(new Clientes(3l, "La Comer", 999932));
		elementos.add(new Clientes(4l, "Costco", 999932));
		elementos.add(new Clientes(5l, "Bodega Aurrera", 999932));
		elementos.add(new Clientes(6l, "Sam's", 999932));
		elementos.add(new Clientes(7l, "Pepsi", 999932));
		elementos.add(new Clientes(8l, "Tiendas 3 B", 999932));
		elementos.add(new Clientes(9l, "Chedraui", 999932));
		elementos.add(new Clientes(10l, "Otro", 999932));
		return elementos;
	}
	//agregar tiendas en lugar de clientes

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
		BitMatrix bitMatrix = new MultiFormatWriter().encode("Total: " + qr.getSumaTotal() + "\nNombreProducto: "
				+ qr.getLista() + "\nProductos totales: " + qr.getLista().size() + "\nNumero de Cuenta: " + qr.getNumeroCuenta() + " \nTienda: " + qr.getNombre() + "\nNumero empleado: "+ qr.getNumeroEmpleado() ,
				BarcodeFormat.QR_CODE, 250, 250);
		MatrixToImageWriter.writeToStream(bitMatrix, MediaType.IMAGE_PNG.getSubtype(), baos, new MatrixToImageConfig());
		byte[] data = baos.toByteArray();
		String encodedString = Base64.getEncoder().encodeToString(data);

		return encodedString;

	}

}
