package in.nareshit.raghu.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nareshit.raghu.model.Product;
import in.nareshit.raghu.repo.ProductRepository;
import in.nareshit.raghu.service.IProductService;

@Service // cal + Oper + Sorting+Tx
public class ProductServiceImpl 
implements IProductService {

	@Autowired
	private ProductRepository repo;

	@Override
	@Transactional
	public Integer saveProduct(Product p) {
		//calculations
		//JDK 10-var reserve word
		var cost = p.getProdCost();

		var disc = cost * 12/100.0;
		var gst = cost * 8/100.0;

		p.setProdGst(gst);
		p.setProdDiscount(disc);

		return repo.save(p).getProdId();
	}


	@Override
	@Transactional(readOnly = true)
	public List<Product> getAllProcust() {
		List<Product> list = repo.findAll();
		Collections.sort(list,
				//(o1,o2)->o2.getProdId()-o1.getProdId() //DESC based on PID
				//(o1,o2)->o2.getProdCode().compareTo(o1.getProdCode()) //DESC based on PID
				(o1,o2)->o1.getProdCode().compareTo(o2.getProdCode()) //ASC based on PID
				);

		/** JDK 1.8 new method
		list.sort(
				(o1,o2)->o2.getProdId()-o1.getProdId() //DESC based on PID
				); 
		 */
		/*
		 * USING JDK 1.8 Streams
		return 
				list.stream()
					.sorted(
							(o1,o2)->o2.getProdId()-o1.getProdId()
							);
		 */
		//Collections.sort(list,(o1,o2)->o1.getProdId()-o2.getProdId()); //ASC based on PID
		return list;
	}

	@Override
	public void deleteProduct(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Product getOneProduct(Integer id) {
		Optional<Product> opt = repo.findById(id);
		if(opt.isPresent())
			return opt.get();
		return null;
	}

	@Override
	public void updateProduct(Product p) {

		//JDK 10-var reserve word
		var cost = p.getProdCost();

		var disc = cost * 12/100.0;
		var gst = cost * 8/100.0;

		p.setProdGst(gst);
		p.setProdDiscount(disc);
		repo.save(p);
	}

}




