db.people.mapReduce(
	function () {
		this.credit.forEach(function (credit) {
			sum_balance = parseFloat(credit.balance);
			currency = credit.currency;
	
		emit(currency, {sum_balance, count: 1});
		});
	},
	
	function (key, values) {
	var reducedVal = {
		count: 0,
		sum_balance: 0,
	}
		
	values.forEach(function (value) {
		reducedVal.count += value.count;
		reducedVal.sum_balance += value.sum_balance;
	});
		
	return reducedVal;
	},
	
	{
		out: 'pl_female_balances',
		query: {
			"nationality": "Poland",
			"sex": "Female"
		},
		finalize: function (key, reducedVal) {			
			reducedVal.sum_balance = (reducedVal.sum_balance).toFixed(2);
			reducedVal.avg = (reducedVal.sum_balance / reducedVal.count).toFixed(2);
			delete reducedVal.count;
			return reducedVal;
		},
	}
);

printjson(db.pl_female_balances.find().toArray());