/*
 * Copyright The Athenz Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import React from 'react';
import { render } from '@testing-library/react';
import CollectionDetails from '../../../components/header/CollectionDetails';

describe('RoleDetails', () => {
    it('should render', () => {
        const roleMetadata = {
            modified: '2020-02-12T21:44:37.792Z',
        };

        const { getByTestId } = render(
            <CollectionDetails collectionDetails={roleMetadata} />
        );
        const domainDetails = getByTestId('collection-details');
        expect(domainDetails).toMatchSnapshot();
    });
    it('should render with mock data', () => {
        const roleMetadata = {
            modified: '2020-12-01T21:44:37.792Z',
            lastReviewedDate: '2020-12-01T21:44:37.792Z',
        };

        const { getByTestId } = render(
            <CollectionDetails collectionDetails={roleMetadata} />
        );
        const roleDetails = getByTestId('collection-details');
        expect(roleDetails).toMatchSnapshot();
    });
});
