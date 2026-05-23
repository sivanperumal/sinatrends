package com.javacode.sinatrends.seeds;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.javacode.sinatrends.entity.Category;
import com.javacode.sinatrends.entity.Collection;
import com.javacode.sinatrends.entity.Product;
import com.javacode.sinatrends.enums.ProductType;
import com.javacode.sinatrends.repository.CategoryRepository;
import com.javacode.sinatrends.repository.CollectionRepository;
import com.javacode.sinatrends.repository.ProductRepository;

@Component
public class ProductSeeder implements CommandLineRunner{
	
	@Autowired
	private CollectionRepository collectionRepo;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		if(collectionRepo.count() == 0) {
				
						List<Collection> demoCollections = List.of(	new Collection(
																	null, 
																	"Premium Temple Jewellery",
																	"premium-temple-jewellery",
																	"/products/banner/premium_temple_jewellery.png",
																	"/products/3_1.jpg",
																	true,
																	LocalDateTime.now(),
																	LocalDateTime.now(),
																	findCat("collections")
															),
															new Collection(
																	null, 
																	"Guaranteed One Gram Micro Gold Plated Jewellery",
																	"guaranteed-one-gram-micro-gold-plated-jewellery",
																	"/products/banner/premium_temple_jewellery.png",
																	"/products/6.jpg",
																	true,
																	LocalDateTime.now(),
																	LocalDateTime.now(),
																	findCat("collections")
															),
															new Collection(
																	null, 
																	"Classic Temple Jewellery",
																	"classic-temple-jewellery",
																	"/products/banner/premium_temple_jewellery.png",
																	"/products/3_d44e2948-1456-43ad-b159-b8514f0ad5a6.jpg",
																	true,
																	LocalDateTime.now(),
																	LocalDateTime.now(),
																	findCat("collections")
															),
															new Collection(
																	null, 
																	"American Diamond Jewellery",
																	"american-diamond-jewellery",
																	"/products/banner/premium_temple_jewellery.png",
																	"/products/5.jpg",
																	true,
																	LocalDateTime.now(),
																	LocalDateTime.now(),
																	findCat("collections")
															),
															new Collection(
																	null, 
																	"Oxidised Jewellery",
																	"oxidised-jewellery",
																	"/products/banner/Palaka-Desktop_417534ab-a539-40a5-88e4-87cf7dfa3b69.png",
																	"/products/2_1_8ae1ec1f-f1f7-4bbe-8773-135c19819f80.jpg",
																	true,
																	LocalDateTime.now(),
																	LocalDateTime.now(),
																	findCat("collections")
															),
															new Collection(
																	null, 
																	"Tikkas",
																	"tikkas",
																	"/products/banner/premium_temple_jewellery.png",
																	"/products/Tikka.jpg",
																	true,
																	LocalDateTime.now(),
																	LocalDateTime.now(),
																	findCat("accessories")
															),
															new Collection(
																	null, 
																	"Pendants",
																	"pendants",
																	"/products/banner/premium_temple_jewellery.png",
																	"/products/Pendant.jpg",
																	true,
																	LocalDateTime.now(),
																	LocalDateTime.now(),
																	findCat("accessories")
															),
															new Collection(
																	null, 
																	"Matil",
																	"matil",
																	"/products/banner/premium_temple_jewellery.png",
																	"/products/Matil.jpg",
																	true,
																	LocalDateTime.now(),
																	LocalDateTime.now(),
																	findCat("accessories")
															),
															new Collection(
																	null, 
																	"Anklets",
																	"anklets",
																	"/products/banner/premium_temple_jewellery.png",
																	"/products/Anklet.jpg",
																	true,
																	LocalDateTime.now(),
																	LocalDateTime.now(),
																	findCat("accessories")
															),
															new Collection(
																	null, 
																	"Oxidised Bangles",
																	"oxidised-bangles",
																	"/products/banner/premium_temple_jewellery.png",
																	"/products/Oxidised-Antique--Bangles.jpg",
																	true,
																	LocalDateTime.now(),
																	LocalDateTime.now(),
																	findCat("bangles")
															),
															new Collection(
																	null, 
																	"Antique Bangles",
																	"antique-bangles",
																	"/products/banner/premium_temple_jewellery.png",
																	"/products/Oxidised-Antique--Bangles.jpg",
																	true,
																	LocalDateTime.now(),
																	LocalDateTime.now(),
																	findCat("bangles")
															)
						);	
						collectionRepo.saveAll(demoCollections);
						System.out.println("Collection seeds are saved.");
		}
		else {
			System.out.println("Collection seeds are already in DB.");
		}
		if(productRepository.count() == 0) {
				
				List<Product> demoProducts = List.of
						(
								new Product(null, 
										  "Feathered Elegance Peacock Stud Earrings-Temple Matte Gold Plated AD Earrings",
										  "temple-gold-ad-stone-peacock-tops-earrings",
										  "Elevate your style with our Peacock Round Stud Earrings. Featuring a mesmerizing display of feathers, these earrings exude elegance and charm. ",
										  "Elevate your style with our Peacock Round Stud Earrings. Featuring a mesmerizing display of feathers, these earrings exude elegance and charm. Crafted with attention to detail, they add a touch of regal splendor to any outfit.",
										  2430.0,
										  569.0,
										  5.0,
										  2,
										  true,
										  false,
										  false,
										  ProductType.EARRING,
										  findCat("earrings"),
										  List.of(
										   "/products/Classic-Peacock-Design-Temple-Matte-Gold-Plated-Stud-Earrings-With-American-Diamond-Highlights-And-Centre-Ruby-For-Grand-Ethnic-Looks-Sasitrends-1952A.jpg",
										   "/products/Divine-Green-Feathered-Elegance-Peacock-Temple-Matte-Gold-Plated-AD-Stud-Earrings-Sasitrends-1952B.jpg"
										  ),
										  LocalDateTime.now(),
										  LocalDateTime.now()),
								new Product(null, 
										  "Divine Grace: The Mesmerizing Temple Matte Gold Plated Lakshmi Bridal Bangle",
										  "lakshmi-lotus-bangle",
										  "The traditional matte gold-plated necklace set is a stunning piece of jewelry made from brass and plated with matte gold.",
										  "The traditional matte gold-plated necklace set is a stunning piece of jewelry made from brass and plated with matte gold. It features three layers soldered together, with the bottom layer adorned with leaf motifs, the middle layer with larger balls, and the top layer arranged in a rectangular shape with an additional ball soldered in the middle. The set also includes Leaf crafted jhumka earrings with hanging pearls.",
										  3310.0,
										  762.0,
										  4.8,
										  4,
										  true,
										  false,
										  false,
										  ProductType.BANGLE,
										  findCat("bangles"),
										  List.of(
												   "/products/2234b-exquisite-temple-lakshmi-bridal-bangle-in-matte-gold-plating-with-rich-traditional-artwork-and-sacred-goddess-motif-for-ethnic-festive-jewellery-look-sasitrends.jpg",
												   "/products/Divine-grace-temple-matte-gold-plated-lakshmi-bridal-bangle-with-ethnic-carvings-and-regal-details-for-traditional-indian-wedding-jewellery-style-sasitrends-2234B.jpg"
										  ),
										  LocalDateTime.now(),
										  LocalDateTime.now()),	
								new Product(null, 
											"Elegant Interlaced American Diamond Bangles Pair | Traditional One Gram Micro Gold Plated Design",
										  "interlaced-festive-bangles",
										  "Elevate elegance with our exquisite bangle set, combining tradition and style.",
										  "Elevate elegance with our exquisite bangle set, combining tradition and style. Crafted from brass, plated with one gram micro gold using 24 carat pure gold, and embellished with delicate white stones. The set features a charming arrangement of pipe motifs and paired stones, creating a cross-alternate design.",
										  2899.0,
										  699.0,
										  5.0,
										  27,
										  true,
										  false,
										  false,
										  ProductType.BANGLE,
										  findCat("bangles"),
										  List.of(
												   "/products/american-diamond-bangles.jpg",
												   "/products/american-diamond-bangles-ruby.jpg",
												   "/products/american-diamond-bangles-ruby-white.jpg"
										  ),
										  LocalDateTime.now(),
										  LocalDateTime.now()),
								new Product(null, 
									"Gold Plated American Diamond Nose Pin for Women",
									  "american-diamond-nose-ring",
									  "Designer AD Stone Nose Pin will make you feel Royal. The material used is skin-friendly and anti-allergic.",
									  "Designer AD Stone Nose Pin will make you feel Royal. The material used is skin-friendly and anti-allergic. Easy to wear, light in weight & gives you a rich look. It is perfect for daily wear, marriage, engagement ceremonies, birthdays, parties, and other special occasions.  Sasitrends is committed to providing the best jewellery and best customer services to our customers. This piece of jewellery comes with the Sasitrends assurance of quality and durability. Care instructions- First wear your makeup, perfume, and then wear your jewelry. This will keep your jewelry shining for years. Please store it in an air-tight container.",
									  2500.0,
									  249.0,
									  4.0,
									  12,
									  true,
									  false,
									  false,
									  ProductType.NOSE_PIN,
									  findCat("accessories"),
									  List.of(
											   "/products/American-Diamond-Nose-Pin-1.jpg",
											   "/products/American-Diamond-Nose-Pin-2.jpg"
									  ),
									  LocalDateTime.now(),
									  LocalDateTime.now()),
								new Product(null, 
										"Exquisite Temple Matte Gold Plated Necklace Jewellery Set: A Timeless Treasure for Special Occasion",
										  "three-layer-necklace-jhumka-2238b",
										  "The traditional matte gold-plated necklace set is a stunning piece of jewelry made from brass and plated with matte gold.",
										  "The traditional matte gold-plated necklace set is a stunning piece of jewelry made from brass and plated with matte gold. It features three layers soldered together, with the bottom layer adorned with leaf motifs, the middle layer with larger balls, and the top layer arranged in a rectangular shape with an additional ball soldered in the middle.",
										  4702.0,
										  1108.0,
										  4.3,
										  21,
										  true,
										  false,
										  false,
										  ProductType.NECKLACE,
										  findCat("necklaces"),
										  List.of(
												   "/products/DSC08475.jpg"
										  ),
										  LocalDateTime.now(),
										  LocalDateTime.now()),
								new Product(null, 
								  "Kolapuri Oxidised Stone Toe Rings – Traditional Adjustable Oxidised Jewellery",
								  "kolapuri-oxidised-stone-toe-rings-1908a-for-special-occasions",
								  "Step into the world of timeless beauty with these Kolapuri Oxidised Stone Toe Rings,",
								  "Step into the world of timeless beauty with these Kolapuri Oxidised Stone Toe Rings, designed to reflect tradition and grace. This exquisite set showcases two unique designs—one featuring a delicate floral motif adorned with a radiant stone, and the other capturing the elegance of a peacock design with intricate detailing.",
								  1254.0,
								  126.0,
								  4.4,
								  9,
								  true,
								  false,
								  false,
								  ProductType.RING,
								  findCat("accessories"),
								  List.of(
										   "/products/Stylish-Adjustable-Traditional-Oxidised-Toe-Rings.jpg"
								  ),
								  LocalDateTime.now(),
								  LocalDateTime.now()),
								new Product(null, 
										  "Oxidised Silver Chain Pendant Necklace with Unique Spiral Floral Motif and Beaded Details – Traditional and Navaratri Special Jewellery",
										  "oxidised-spiral-floral-chain-pendant-necklace-1040",
										  "Elevate your ethnic style with this stunning Oxidised Silver Chain Pendant Necklace",
										  "Elevate your ethnic style with this stunning Oxidised Silver Chain Pendant Necklace featuring a distinct spiral floral motif, artistically bordered by intricate heart-scroll-like extensions that enhance its antique charm. ",
										  309.0,
										  999.0,
										  4.6,
										  7,
										  true,
										  false,
										  false,
										  ProductType.CHAIN,
										  findCat("chains"),
										  List.of(
												   "/products/oxidised-necklace-with-beaded-1.jpg",
												   "/products/oxidised-necklace-with-beaded-2.jpg"		
										  ),
										  LocalDateTime.now(),
										  LocalDateTime.now()),
								new Product(null, 
										  "Exquisite Floral Motif Micro Gold Plated Maang Tikka with AD Stones",
										  "maang-tikka-gold-plated",
										  "Elevate your traditional look with our stunning gold plated maang tikka, featuring a captivating floral pattern adorned with a central round stone and delicate leaf motifs.",
										  "Elevate your traditional look with our stunning gold plated maang tikka, featuring a captivating floral pattern adorned with a central round stone and delicate leaf motifs. The intricate design, encrusted with shimmering AD stones, exudes elegance. The tikka chain offers flexibility, with the motif and chain connecting through a thilak shaped embellishment studded with AD stones. The bottom of the tikka is adorned with graceful hanging bead drops. ",
										  1800.0,
										  362.0,
										  4.5,
										  9,
										  true,
										  false,
										  false,
										  ProductType.ACCESSORIES,
										  findCat("accessories"),
										  List.of(
												   "/products/Gold-Plated-Maang-Tikka-with-Vibrant-Multi-Colored.jpg",
												   "/products/Gold-Plated-Maang-Tikka-with-White.jpg",
												   "/products/Gold-Plated-Maang-Tikka-with-Ruby.jpg",
												   "/products/Gold-Plated-Maang-Tikka-with-RubyGreen.jpg"
										  ),
										  LocalDateTime.now(),
										  LocalDateTime.now()),
								new Product(null, 
										  "Floral Motif Rose Gold Maang Tikka with American Diamond Stones",
										  "floral-rose-gold-maang-tikka",
										  "Elevate your festive look with our exquisite Floral Motif Rose Gold Maang Tikka.",
										  "Elevate your festive look with our exquisite Floral Motif Rose Gold Maang Tikka. The tikka motif features a rectangular-shaped center stone surrounded by a gorgeous floral pattern with leaf stones.",
										  1875.0,
										  381.0,
										  4.8,
										  2,
										  true,
										  false,
										  false,
										  ProductType.ACCESSORIES,
										  findCat("accessories"),
										  List.of(
												   "/products/White-AD-Rose-Gold-Floral-Maang-Tikka.jpg",
												   "/products/Party-Wear-Mint-Green-Rose-Gold-AD-Maang-Tikka.jpg",
												   "/products/Baby-Pink-AD-Rose-Gold-Maang-Tikka.jpg"
										  ),
										  LocalDateTime.now(),
										  LocalDateTime.now()),
								new Product(null, 
										  "Gorgeous Micro Gold Plated Chakara Pendant with AD Stone Embellishments",
										  "2346a-tradtional-wear-multi-ad-stone-micro-gold-plated-chakara-pendant",
										  "This gorgeous Micro Gold micro-plated chakara Pendant will add a touch of elegance to any traditional outfit.",
										  "This gorgeous Micro Gold micro-plated chakara Pendant will add a touch of elegance to any traditional outfit. It is painstakingly made of premium brass and set with brilliant American diamond stones.",
										  589.0,
										  2499.0,
										  4.5,
										  5,
										  true,
										  false,
										  false,
										  ProductType.ACCESSORIES,
										  findCat("accessories"),
										  List.of(
												   "/products/Vibrant-Multi-Colored-Traditional-Micro-Gold.jpg",
												   "/products/wear-multi-whiteruby-stone-micro-gold.jpg"		
										  ),
										  LocalDateTime.now(),
										  LocalDateTime.now()),
								new Product(null, 
										  "Amazing Collection of Micro Gold Plated American Diamond Oval Stone Pendant Dollar",
										  "micro-gold-plated-oval-american-diamond-pendant-dollar",
										  "This Micro Gold Plated American Diamond Oval Pendant Dollar is a beautifully handcrafted one gram jewellery piece that effortlessly blends elegance",
										  "This Micro Gold Plated American Diamond Oval Pendant Dollar is a beautifully handcrafted one gram jewellery piece that effortlessly blends elegance, radiance, and traditional charm. Designed using 24 Carat Pure Gold plating, this pendant is guaranteed to look like real gold, making it a perfect addition to any ethnic or festive outfit. The standout feature of this pendant is its bold oval-shaped central stone, which is available in multiple classic hues, providing the flexibility to match various sarees, salwars, and traditional ensembles.",
										  269.0,
										  1299.0,
										  5.0,
										  1,
										  true,
										  false,
										  false,
										  ProductType.ACCESSORIES,
										  findCat("accessories"),
										  List.of(
												   "/products/traditional-green-oval-stone-dollar.jpg",
												   "/products/mint-oval-pendant-dollar.jpg",
												   "/products/pastel-pink-oval-dollar.jpg"
										  ),
										  LocalDateTime.now(),
										  LocalDateTime.now()),
								new Product(null, 
										  "Radiant Traditional Impon Micro Gold Plated Round Stone Chain Matil ",
										  "radiant-traditional-impon-micro-gold-plated-round-stone-chain-matil",
										  "Bring home the glow of heritage styling with this Impon micro gold plated round stone chain matil, designed to express simplicity wrapped in timeless tradition.",
										  "Bring home the glow of heritage styling with this Impon micro gold plated round stone chain matil, designed to express simplicity wrapped in timeless tradition. The evenly arranged round stones create a rhythmic pattern that enhances the graceful fall of the chain, offering a dignified and devotional appearance.Created using a guaranteed Impon micro gold plated finish, this chain matil reflects the beauty of one gram jewellery craftsmanship. ",
										  341.0,
										  1590.0,
										  4.7,
										  2,
										  true,
										  false,
										  false,
										  ProductType.ACCESSORIES,
										  findCat("accessories"),
										  List.of(
												   "/products/White-round-stone-impon-micro-gold-plated-chain-matil.jpg",
												   "/products/Majestic-circle-impon-micro-gold-plated-stone-chain-matil-white-ruby.jpg",
												   "/products/Grand-spectrum-impon-micro-gold-plated-round-stone-chain-matil-multi.jpg"
										  ),
										  LocalDateTime.now(),
										  LocalDateTime.now()),
								new Product(null, 
										  "Traditional Temple Matte Gold Plated Finish Floral Stone Work Multi-Strand Beaded Ear Chains (Matil)",
										  "temple-matte-gold-plated-floral-multi-layer-ear-chains-matil",
										  "Celebrate traditional elegance with these temple-inspired ear chains (Matil), beautifully designed with intricate floral elements and cascading multi-layer bead chains. ",
										  "Celebrate traditional elegance with these temple-inspired ear chains (Matil), beautifully designed with intricate floral elements and cascading multi-layer bead chains. The structure showcases a symmetrical arrangement where finely detailed motifs are connected through multiple delicate strands, creating a graceful and elongated drape.The design features eye-catching floral patterns placed at intervals, each highlighted with precisely set stones that enhance the richness of the piece. ",
										  1029.0,
										  4199.0,
										  4.8,
										  3,
										  true,
										  false,
										  false,
										  ProductType.ACCESSORIES,
										  findCat("accessories"),
										  List.of(
												   "/products/ruby-temple-matte-gold-plated-floral-multi-layer-ear-chains-matil.jpg",
												   "/products/ruby-green-temple-matte-gold-plated-floral-matil-ear-chains-festive-wear.jpg"
										  ),
										  LocalDateTime.now(),
										  LocalDateTime.now()),
								new Product(null, 
										  "Traditional Micro Gold Plated Anklets with Intricate Beading",
										  "micro-gold-plated-anklets-intricate-beading",
										  "Elevate your accessory collection with our stunning guaranteed micro gold plated anklets. ",
										  "Elevate your accessory collection with our stunning guaranteed micro gold plated anklets. Featuring two rows of delicately linked spherical beads, these anklets boast a refined texture that’s both simple and sophisticated. The secure clasp, adorned with decorative beads, ensures a comfortable fit while enhancing the anklet's charm.",
										  679.0,
										  2867.0,
										  4.8,
										  3,
										  true,
										  false,
										  false,
										  ProductType.ACCESSORIES,
										  findCat("accessories"),
										  List.of(
												   "/products/guaranteed-one-gram-micro-gold-plated-ankletss-with-hanging-beads.jpg",
												   "/products/elegant-micro-gold-plated-anklets-intricate-beading.jpg"
										  ),
										  LocalDateTime.now(),
										  LocalDateTime.now())
								
						);
				productRepository.saveAll(demoProducts);
				System.out.print("Seeds all products ...");
		}
		else {
			System.out.print("Products seeds done...");
		}
	}
	
	public Category findCat(String slug) {
		Category category = categoryRepo.findBySlug(slug).orElseThrow(()-> new RuntimeException("Category not found by this "+slug));
		return category;
	}

}
