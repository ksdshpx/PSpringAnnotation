package cn.ksdshpx.beans;

/**
 * @author peng.x
 * @date 2019年1月8日 上午10:56:41
 */
public class Color {
	private Car car;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Color [car=" + car + "]";
	}

}
