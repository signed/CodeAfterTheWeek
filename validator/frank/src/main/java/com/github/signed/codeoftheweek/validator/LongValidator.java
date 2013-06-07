package com.github.signed.codeoftheweek.validator;

public interface LongValidator {
	void validate(long value) throws ValidatorException;

	public abstract class Abstract implements LongValidator {
		protected void validate(boolean aCondition, String aMessage) throws ValidatorException {
			if (!aCondition)
				throw new ValidatorException(Severity.ERROR, aMessage);
		}

		@Override
		public void validate(long value) throws ValidatorException {
		}
	}

	public class Ok extends Abstract {
	}

	public abstract class Limited extends Abstract {
		protected final long limit;

		public Limited(long aLimit) {
			limit = aLimit;
		}
	}

	public class Min extends Limited {
		public Min(long aMinimum) {
			super(aMinimum);
		}

		@Override
		public void validate(long value) throws ValidatorException {
			validate(limit <= value, "Zahl ab " + limit + " erwartet.");
		}
	}

	public class Max extends Limited {
		public Max(long aMaximum) {
			super(aMaximum);
		}

		@Override
		public void validate(long value) throws ValidatorException {
			validate(value <= limit, "Zahl bis " + limit + " erwartet.");
		}
	}

	public class MinMax extends Abstract {
		private final LongValidator minValidator;
		private final LongValidator maxValidator;

		public MinMax() {
			this(null, null);
		}

		public MinMax(Long aMinimum, Long aMaximum) {
			minValidator = aMinimum == null ? new Ok() : new Min(aMinimum);
			maxValidator = aMaximum == null ? new Ok() : new Max(aMaximum);
		}

		@Override
		public void validate(long value) throws ValidatorException {
			minValidator.validate(value);
			maxValidator.validate(value);
		}
	}
}
