/**
 *原型模式是指创建重复的对象,同时保持性能。这种类型的设计模式是在创建的模式,这种模式提供了最好的方法之一来创建一个对象。
 *这种模式需要实现一个原型接口告诉当前对象的创建一个克隆。这种模式是直接创建对象时使用的是昂贵的。例如,要创建一个对象后,昂贵的数据库操作。我们可以缓存对象,返回其克隆对下一个请求和在需要时更新数据库,从而减少数据库调用。
 *
 * http://www.tutorialspoint.com/design_pattern/prototype_pattern.htm
 *
 * @author qingbao.ho@gmail.com
 * @date 2015年7月20日 下午1:30:50
 * @version V1.0
 *
 */
package designpatterns.prototype;