# react-native-consisty-payswiff-matm

Payswiff MATM device SDK for react-native in android

## Installation

```sh
npm install react-native-consisty-payswiff-matm
```

## Usage


```js
import { NativeModules, PermissionsAndroid, Platform } from 'react-native';

const LINKING_ERROR = 'Native module not found';
const ConsistyPayswiffMatm = NativeModules.ConsistyPayswiffMatm
  ? NativeModules.ConsistyPayswiffMatm
  : new Proxy(
    {},
    {
      get() {
        throw new Error(LINKING_ERROR);
      },
    }
  );

const initiateMatmTransaction = async (config: TransactionConfig): Promise<TransactionResult> => {
  try {
    const result = await ConsistyPayswiffMatm.initiateTransaction(config);
    return result;
  } catch (error) {
    throw error;
  }
};

// ...

const config: TransactionConfig = {
        transactionType: transactionType,
        amount: amount,
        merchantKey: merchantKey,
        partnerKey: partnerKey,
        orderId: orderId,
        deviceName: deviceName,
        deviceMACAddress: deviceMACAddress
      };

      setLoading(true);
      const resultData = await initiateMatmTransaction(config);

      const {
        statusCode,
        message,
        rrn,
        accountHolderName,
        accountBalance,
        cardBrand,
        cardType,
        transactionDateTime,
        terminalSerialNo,
        ledgerBalance,
      } = resultData;
```


## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
