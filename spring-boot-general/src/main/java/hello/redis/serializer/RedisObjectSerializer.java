/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package hello.redis.serializer;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * ClassName: RedisObjectSerializer
 *
 * @Author: ljiang
 * @Date: Nov 14, 2016 4:28:55 PM
 */
public class RedisObjectSerializer implements RedisSerializer<Object> {

	private Converter<Object, byte[]> serializer = new SerializingConverter();
	private Converter<byte[], Object> deserializer = new DeserializingConverter();

	static final byte[] EMPTY_ARRAY = new byte[0];

	public byte[] serialize(Object object) throws SerializationException {
		if (object == null) {
			return EMPTY_ARRAY;
		}
		try {
			return serializer.convert(object);
		} catch (Exception ex) {
			return EMPTY_ARRAY;
		}
	}

	public Object deserialize(byte[] bytes) throws SerializationException {
		if (isEmpty(bytes)) {
			return null;
		}
		try {
			return deserializer.convert(bytes);
		} catch (Exception ex) {
			throw new SerializationException("Cannot deserialize", ex);
		}
	}

	private boolean isEmpty(byte[] data) {
		return (data == null || data.length == 0);
	}
}
