export interface Customer {
    id: string,
    customerId: string,
    customerName: string,
    phone: string,
    email: string,
    address: string,
    status: boolean,
    version: number,
    createdAt: string,
    createdByUserId: string,
    updatedAt: string
}

export interface AddCustomer {
    customerName: string,
    phone: string,
    email: string,
    address: string,
}