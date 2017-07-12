package br.com.avenuecode;

import org.junit.runners.Suite.SuiteClasses;

import br.com.avenuecode.product.ImageTests;
import br.com.avenuecode.product.ProductTests;

@SuiteClasses({
	ImageTests.class,
	ProductTests.class
})
public class ApplicationTests {

}
