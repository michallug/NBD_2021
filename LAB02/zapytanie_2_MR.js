printjson(
    db.people.mapReduce(
		function() {
			this.credit.forEach(function (credit) {
				balance = parseFloat(credit.balance);
				currency = credit.currency;

			  emit(currency, balance);
			});
		},
		function(key, values) {
			return Array.sum(values);
		},
		{
			out: { inline: 1 }
		}
	)
);