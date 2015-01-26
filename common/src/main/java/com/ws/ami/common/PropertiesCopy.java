package com.ws.ami.common;


import org.apache.commons.beanutils.BeanUtils;

/**
 * 属性拷贝类：拷贝一个类的属性到另外一个目标类.可以减少set方法
 * Created by hp on 2015/1/22.
 */
public class PropertiesCopy {

    public static void main(String[] args) throws Exception {

        spring();
        apache();
    }

    /**
     * spring bean BeanUtils的转换
     */
    private static void spring() {
        Dog dog = new Dog();
        dog.setDogMouth(1);
        dog.setDogName("dogName");
        dog.setAnimalMouth(1);
        dog.setAnimalName("animalName");
        TargetDog tdog = new TargetDog();
       // BeanUtils.copyProperties(dog, tdog);
    }


    /**
     * apache bean BeanUtils的转换
     */
    private static void apache() throws Exception
    {
        Dog dog = new Dog();
        dog.setDogMouth(1);
        dog.setDogName("dogName");
        dog.setAnimalMouth(1);
        dog.setAnimalName("animalName");
        TargetDog tdog = new TargetDog();
      // BeanUtils.copyProperties(tdog, dog);

       String a =  BeanUtils.getProperty(tdog, "dogName");



    }
}
