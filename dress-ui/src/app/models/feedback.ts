export interface IFeedback {
    id: string,
    rating: number,
    status: boolean,
    version: number,
    createdAt: string,
    orderId: string,
    customerId: string,
    description: string
}